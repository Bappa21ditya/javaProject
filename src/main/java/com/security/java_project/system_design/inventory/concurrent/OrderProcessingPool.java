package com.security.java_project.system_design.inventory.concurrent;

import java.util.List;
import java.util.concurrent.*;

/**
 * ─────────────────────────────────────────────────────────────────
 * CONCEPT 2 : ThreadPoolExecutor  (process orders concurrently)
 * ─────────────────────────────────────────────────────────────────
 *
 * PROBLEM:
 *   During a flash sale, 1000 orders arrive per second.
 *   Processing them one-by-one (sequential) is too slow.
 *
 * SOLUTION — ThreadPoolExecutor:
 *   - Maintain a POOL of pre-created threads (cheaper than new Thread each time)
 *   - Submit tasks; pool threads pick them up and execute concurrently
 *   - Excess tasks wait in a bounded queue (prevents OOM under spike load)
 *
 * ThreadPoolExecutor Parameters:
 *
 *   corePoolSize    = 2   → always keep 2 threads alive (even if idle)
 *   maximumPoolSize = 5   → can grow up to 5 threads under heavy load
 *   keepAliveTime   = 30s → extra threads (beyond core) die after 30s idle
 *   workQueue            → holds tasks waiting for a free thread
 *                          LinkedBlockingQueue(10) → max 10 pending tasks
 *   RejectedHandler      → what to do when queue is full (CallerRunsPolicy
 *                          makes the calling thread itself run the task —
 *                          natural backpressure, no task dropped)
 *
 * vs Executors.newFixedThreadPool(n):
 *   Executors factory is convenient but hides parameters and uses an
 *   UNBOUNDED queue — dangerous in production (OOM risk).
 *   Always prefer explicit ThreadPoolExecutor in real systems.
 */
public class OrderProcessingPool {

    private final ThreadPoolExecutor executor;
    private final StockManager stockManager;

    public OrderProcessingPool(StockManager stockManager) {
        this.stockManager = stockManager;

        this.executor = new ThreadPoolExecutor(
            2,                                   // corePoolSize
            5,                                   // maximumPoolSize
            30L, TimeUnit.SECONDS,               // keepAliveTime
            new LinkedBlockingQueue<>(10),       // bounded work queue
            new ThreadFactory() {                // custom thread names (easier debugging)
                private int count = 0;
                @Override
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r, "OrderWorker-" + (++count));
                    t.setDaemon(false); // non-daemon: JVM waits for these to finish
                    return t;
                }
            },
            new ThreadPoolExecutor.CallerRunsPolicy() // backpressure: caller runs task if queue full
        );
    }

    /**
     * Submit an order for async processing.
     * Returns a Future<Boolean> — caller can wait for result or proceed.
     *
     * Future / Callable:
     *   Runnable → fire-and-forget (no return value)
     *   Callable → returns a value; wrap in Future to retrieve it later
     */
    public Future<Boolean> submitOrder(String orderId,
                                       String productId,
                                       int    quantity) {

        Callable<Boolean> orderTask = () -> {
            System.out.printf(
                "[%s] 📦 Processing Order '%s' for product '%s' qty=%d%n",
                Thread.currentThread().getName(), orderId, productId, quantity
            );

            // Simulate payment gateway delay (100–300 ms)
            long delay = 100 + (long)(Math.random() * 200);
            Thread.sleep(delay);

            // Thread-safe stock reservation (uses ReentrantLock internally)
            boolean reserved = stockManager.reserveStock(productId, quantity);

            if (reserved) {
                System.out.printf(
                    "[%s] 🎉 Order '%s' CONFIRMED (took %dms)%n",
                    Thread.currentThread().getName(), orderId, delay
                );
            } else {
                System.out.printf(
                    "[%s] ❌ Order '%s' FAILED — out of stock%n",
                    Thread.currentThread().getName(), orderId
                );
            }
            return reserved;
        };

        return executor.submit(orderTask);
    }

    /**
     * Submit multiple orders and wait for ALL to finish.
     * Uses invokeAll() — blocks until every task completes.
     */
    public List<Future<Boolean>> submitBatch(List<Callable<Boolean>> orders)
            throws InterruptedException {
        return executor.invokeAll(orders);
    }

    /**
     * Print current pool stats — useful to monitor during load.
     */
    public void printPoolStats() {
        System.out.printf(
            "%n[Pool Stats] active=%d | completed=%d | poolSize=%d | queueSize=%d%n",
            executor.getActiveCount(),
            executor.getCompletedTaskCount(),
            executor.getPoolSize(),
            executor.getQueue().size()
        );
    }

    /**
     * Graceful shutdown:
     *   shutdown()         → no new tasks, waits for running tasks to finish
     *   awaitTermination() → block until all done or timeout
     *   shutdownNow()      → forceful: interrupts running threads (last resort)
     */
    public void shutdown() throws InterruptedException {
        System.out.println("\n[Pool] Initiating graceful shutdown...");
        executor.shutdown();
        boolean finished = executor.awaitTermination(10, TimeUnit.SECONDS);
        if (!finished) {
            System.out.println("[Pool] ⚠ Timeout! Forcing shutdown...");
            executor.shutdownNow();
        } else {
            System.out.println("[Pool] ✅ All tasks completed. Shutdown clean.");
        }
    }
}
