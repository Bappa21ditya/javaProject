package com.security.java_project.system_design.inventory.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * ═══════════════════════════════════════════════════════════════════
 *  MULTITHREADING DEMO — Inventory System
 * ═══════════════════════════════════════════════════════════════════
 *
 *  Concepts demonstrated end-to-end:
 *
 *  1. Race Condition       → what happens WITHOUT locking (stock oversell)
 *  2. ReentrantLock        → atomic check-then-act prevents oversell
 *  3. ThreadPoolExecutor   → concurrent order processing with custom pool
 *  4. Future / Callable    → async task submission + result retrieval
 *  5. CompletableFuture    → chained async pipeline for notifications
 *  6. ScheduledExecutor    → delayed reminder notifications
 *  7. Thread.sleep/join    → basic thread coordination
 *  8. Graceful shutdown    → proper pool teardown
 */
public class ConcurrentInventoryDemo {

    public static void main(String[] args) throws Exception {

        System.out.println("═".repeat(60));
        System.out.println("   CONCURRENT INVENTORY SYSTEM — THREADING DEMO");
        System.out.println("═".repeat(60));

        // ── SETUP ──────────────────────────────────────────────────────
        StockManager stockManager = new StockManager();
        stockManager.initStock("LAPTOP", 3);   // only 3 laptops in stock!
        stockManager.initStock("MOBILE", 10);  // 10 mobiles

        OrderProcessingPool orderPool = new OrderProcessingPool(stockManager);
        AsyncNotificationDispatcher dispatcher = new AsyncNotificationDispatcher();


        // ══════════════════════════════════════════════════════════════
        // DEMO 1: Race Condition — WITHOUT lock (to understand the problem)
        // ══════════════════════════════════════════════════════════════
        System.out.println("\n" + "─".repeat(60));
        System.out.println("DEMO 1: Race Condition Demo (no lock — educational only)");
        System.out.println("─".repeat(60));
        demonstrateRaceCondition();


        // ══════════════════════════════════════════════════════════════
        // DEMO 2: ThreadPoolExecutor — 6 concurrent orders for 3 laptops
        //         Only 3 should succeed, 3 should fail (out of stock)
        // ══════════════════════════════════════════════════════════════
        System.out.println("\n" + "─".repeat(60));
        System.out.println("DEMO 2: ThreadPoolExecutor — 6 concurrent orders, only 3 laptops");
        System.out.println("─".repeat(60));

        List<Future<Boolean>> futures = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            String orderId = "ORD-" + i;
            // submitOrder returns Future<Boolean> immediately (non-blocking)
            Future<Boolean> future = orderPool.submitOrder(orderId, "LAPTOP", 1);
            futures.add(future);
        }

        // Now collect results — get() BLOCKS until that specific task finishes
        System.out.println("\n[Main] Waiting for all orders to complete...");
        int success = 0, failed = 0;
        for (int i = 0; i < futures.size(); i++) {
            boolean result = futures.get(i).get(); // blocks here until done
            if (result) success++; else failed++;
        }

        orderPool.printPoolStats();
        System.out.printf("%n[Results] ✅ Confirmed: %d | ❌ Failed: %d | Stock left: %d%n",
            success, failed, stockManager.getStock("LAPTOP"));


        // ══════════════════════════════════════════════════════════════
        // DEMO 3: CompletableFuture + ScheduledExecutor — Async Notifications
        // ══════════════════════════════════════════════════════════════
        System.out.println("\n" + "─".repeat(60));
        System.out.println("DEMO 3: CompletableFuture — Async Notification Pipeline");
        System.out.println("─".repeat(60));

        // Fire all 3 channels in parallel — non-blocking for order thread
        dispatcher.dispatchAllChannels("ORD-1");

        // Schedule a reminder 2 seconds later (simulates real-time status update)
        dispatcher.scheduleDeliveryReminder("ORD-1");

        // Main thread can continue doing other work while notifications fly
        System.out.println("[Main] Order confirmed → response sent to user immediately!");
        System.out.println("[Main] Notifications running in background...");
        Thread.sleep(3500); // wait in demo to see scheduled notification fire


        // ══════════════════════════════════════════════════════════════
        // DEMO 4: invokeAll() — submit batch of tasks, wait for ALL
        // ══════════════════════════════════════════════════════════════
        System.out.println("\n" + "─".repeat(60));
        System.out.println("DEMO 4: invokeAll() — Batch order processing");
        System.out.println("─".repeat(60));

        List<Callable<Boolean>> batchOrders = new ArrayList<>();
        for (int i = 7; i <= 12; i++) {
            final String oid = "ORD-" + i;
            batchOrders.add(() -> {
                Thread.sleep(50);
                System.out.printf("[%s] Batch processing '%s'%n",
                    Thread.currentThread().getName(), oid);
                return stockManager.reserveStock("MOBILE", 1);
            });
        }

        // invokeAll blocks until ALL tasks complete, then returns their futures
        List<Future<Boolean>> batchResults = orderPool.submitBatch(batchOrders);
        long batchSuccess = batchResults.stream()
            .filter(f -> { try { return f.get(); } catch (Exception e) { return false; } })
            .count();
        System.out.printf("[Batch] %d/%d orders succeeded%n",
            batchSuccess, batchOrders.size());


        // ── SHUTDOWN ───────────────────────────────────────────────────
        System.out.println("\n" + "─".repeat(60));
        orderPool.shutdown();
        dispatcher.shutdown();
        System.out.println("═".repeat(60));
        System.out.println("   ALL DEMOS COMPLETE");
        System.out.println("═".repeat(60));
    }


    /**
     * Demonstrates the classic race condition on stock WITHOUT any lock.
     * BOTH threads read stock=1, BOTH think they can reserve, BOTH succeed → oversell!
     *
     * This is for EDUCATIONAL purposes — showing WHY we need locking.
     */
    private static void demonstrateRaceCondition() throws InterruptedException {
        // Shared mutable state — no synchronization
        int[] sharedStock = { 1 }; // only 1 item, but 2 threads will try to buy

        Thread buyer1 = new Thread(() -> {
            // Thread gets preempted here by OS → buyer2 runs before write
            if (sharedStock[0] >= 1) {
                try { Thread.sleep(10); } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                // By now buyer2 also passed the if-check!
                sharedStock[0]--;
                System.out.println("[Buyer-1] ✅ Bought item! Stock=" + sharedStock[0]);
            }
        }, "Buyer-1");

        Thread buyer2 = new Thread(() -> {
            if (sharedStock[0] >= 1) { // SAME check — passes because decrement not done yet
                sharedStock[0]--;
                System.out.println("[Buyer-2] ✅ Bought item! Stock=" + sharedStock[0]);
            }
        }, "Buyer-2");

        buyer1.start();
        buyer2.start();
        buyer1.join(); // wait for buyer1 to finish
        buyer2.join(); // wait for buyer2 to finish

        System.out.println("[Race Condition] Final stock=" + sharedStock[0]
            + " (should be 0, may be -1 → OVERSELL 🐛)");
        System.out.println("[Fix] → Use ReentrantLock (see StockManager.reserveStock)");
    }
}
