package com.security.java_project.system_design.inventory.concurrent;

import java.util.List;
import java.util.concurrent.*;

/**
 * ─────────────────────────────────────────────────────────────────
 * CONCEPT 3 : Async Notification Dispatcher
 *             (ScheduledExecutorService + CompletableFuture)
 * ─────────────────────────────────────────────────────────────────
 *
 * PROBLEM:
 *   Sending Email/SMS/Push notifications after order creation takes
 *   300–500ms each. Running them on the ORDER thread:
 *     • Blocks order response → bad user experience
 *     • Ties up order-processing threads on I/O work
 *
 * SOLUTION — fire notifications on a SEPARATE thread pool:
 *   1. Order processing thread finishes → returns response instantly
 *   2. Notification tasks are submitted to a dedicated pool
 *   3. Users get order confirmation immediately; notifications
 *      arrive moments later in the background
 *
 * This class demonstrates THREE async techniques:
 *   A) ExecutorService.submit()        → basic async with Future
 *   B) CompletableFuture               → chained async pipeline (modern Java 8+)
 *   C) ScheduledExecutorService        → delayed / periodic execution
 */
public class AsyncNotificationDispatcher {

    // Dedicated small pool just for I/O-bound notification tasks
    private final ExecutorService notificationPool =
        Executors.newFixedThreadPool(3,
            r -> new Thread(r, "Notifier-" + System.nanoTime() % 100));

    // For scheduled/periodic tasks (e.g., retry failed notifications every 5 min)
    private final ScheduledExecutorService scheduler =
        Executors.newSingleThreadScheduledExecutor(
            r -> new Thread(r, "NotificationRetry-Scheduler"));

    // ─────────────────────────────────────────────────────────────────
    // A) Basic async dispatch with Future
    //    Returns Future<Void> — caller can check if it's done, but
    //    typically fire-and-forget for notifications.
    // ─────────────────────────────────────────────────────────────────
    public Future<?> dispatchAsync(String channel,
                                   String orderId,
                                   String message) {
        return notificationPool.submit(() -> {
            try {
                // Simulate network I/O delay (email SMTP, SMS gateway, etc.)
                Thread.sleep((long)(100 + Math.random() * 300));
                System.out.printf(
                    "[%s] 📨 [%s] → Order '%s': %s%n",
                    Thread.currentThread().getName(), channel, orderId, message
                );
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // ← restore interrupt flag!
                System.out.printf("[%s] ⚠ Notification interrupted%n",
                    Thread.currentThread().getName());
            }
        });
    }

    // ─────────────────────────────────────────────────────────────────
    // B) CompletableFuture — modern async with chaining
    //
    //    supplyAsync()  → runs on ForkJoinPool (or custom executor)
    //    thenApply()    → transform result (sync, same thread)
    //    thenAccept()   → consume result (no return)
    //    exceptionally()→ handle errors in the pipeline
    //
    //    This is the recommended approach for modern Java code.
    // ─────────────────────────────────────────────────────────────────
    public CompletableFuture<String> sendWithCompletableFuture(String channel,
                                                               String orderId) {
        return CompletableFuture
            // Step 1: fetch user contact (simulated async DB call)
            .supplyAsync(() -> {
                try { Thread.sleep(50); } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return "user@example.com"; // simulated result
            }, notificationPool)

            // Step 2: build the message (transform result)
            .thenApply(contact ->
                String.format("Hi %s, your Order '%s' is confirmed!", contact, orderId))

            // Step 3: send the notification (consume result)
            .thenApplyAsync(msg -> {
                try { Thread.sleep(100); } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.printf(
                    "[%s] ✉ [%s] CompletableFuture sent: %s%n",
                    Thread.currentThread().getName(), channel, msg
                );
                return msg;
            }, notificationPool)

            // Step 4: error handling — if any step fails, recover gracefully
            .exceptionally(ex -> {
                System.out.printf("⚠ Notification failed: %s%n", ex.getMessage());
                return "FAILED";
            });
    }

    // ─────────────────────────────────────────────────────────────────
    // C) ScheduledExecutorService — delayed & periodic tasks
    //
    //    schedule()            → run ONCE after a delay
    //    scheduleAtFixedRate() → run every N seconds (fixed start-to-start)
    //    scheduleWithFixedDelay→ run every N seconds (fixed end-to-start)
    // ─────────────────────────────────────────────────────────────────

    /**
     * Schedule a reminder notification 1 hour after order (simulated as 2 sec).
     * Real use: "Your order is out for delivery" sent when status changes.
     */
    public void scheduleDeliveryReminder(String orderId) {
        System.out.printf("[Scheduler] 🕐 Scheduling reminder for Order '%s' in 2s%n", orderId);

        scheduler.schedule(() -> {
            System.out.printf(
                "[%s] 🔔 REMINDER: Order '%s' is out for delivery!%n",
                Thread.currentThread().getName(), orderId
            );
        }, 2, TimeUnit.SECONDS); // 2 seconds simulates 1 hour in real system
    }

    /**
     * Send all 3 notification channels in parallel and wait for ALL to finish.
     * Uses CompletableFuture.allOf() — aggregates multiple async tasks.
     */
    public void dispatchAllChannels(String orderId) {
        System.out.printf("%n[Dispatcher] Firing all channels for Order '%s'...%n", orderId);

        CompletableFuture<String> emailFuture =
            sendWithCompletableFuture("EMAIL", orderId);

        CompletableFuture<String> smsFuture =
            sendWithCompletableFuture("SMS", orderId);

        CompletableFuture<String> pushFuture =
            sendWithCompletableFuture("PUSH", orderId);

        // Wait for ALL to complete (non-blocking until .join())
        CompletableFuture.allOf(emailFuture, smsFuture, pushFuture)
            .thenRun(() -> System.out.printf(
                "[%s] ✅ All notifications sent for Order '%s'%n",
                Thread.currentThread().getName(), orderId
            ))
            .join(); // block here only to see output in demo; avoid in prod
    }

    public void shutdown() throws InterruptedException {
        notificationPool.shutdown();
        scheduler.shutdown();
        notificationPool.awaitTermination(5, TimeUnit.SECONDS);
        scheduler.awaitTermination(5, TimeUnit.SECONDS);
    }
}
