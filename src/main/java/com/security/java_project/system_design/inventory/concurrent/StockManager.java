package com.security.java_project.system_design.inventory.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ─────────────────────────────────────────────────────────────────
 * CONCEPT 1 : ReentrantLock  (finer-grained than synchronized)
 * ─────────────────────────────────────────────────────────────────
 *
 * PROBLEM (Race Condition):
 *   Thread-1 reads stock = 1  (wants to buy 1 laptop)
 *   Thread-2 reads stock = 1  (wants to buy 1 laptop)
 *   Thread-1 writes stock = 0  ✅
 *   Thread-2 writes stock = 0  ✅  ← OVERSELL! Both succeed on 1 item.
 *
 * SOLUTION:
 *   Use ReentrantLock to ensure only ONE thread can read+write
 *   stock at a time. The "check-then-act" block becomes atomic.
 *
 * WHY ReentrantLock over synchronized?
 *   ✔ tryLock()  — attempt lock without blocking forever
 *   ✔ lockInterruptibly() — can be interrupted while waiting
 *   ✔ fairness   — new ReentrantLock(true) serves threads in order
 *   ✔ Condition  — fine-grained wait/signal (like wait/notify but better)
 */
public class StockManager {

    // One lock per product — avoids unnecessary contention across products
    private final Map<String, Integer>     stock = new HashMap<>();
    private final Map<String, ReentrantLock> locks = new HashMap<>();

    /**
     * Add a product with initial stock.
     * Called during setup, before concurrent threads start — no locking needed here.
     */
    public synchronized void initStock(String productId, int quantity) {
        stock.put(productId, quantity);
        locks.put(productId, new ReentrantLock(true)); // fair=true → FIFO ordering
    }

    /**
     * Reserve stock atomically.
     *
     * lock()   → acquires lock, blocks if another thread holds it
     * unlock() → MUST be in finally so it always releases even on exception
     */
    public boolean reserveStock(String productId, int qty) {
        ReentrantLock lock = locks.get(productId);
        if (lock == null) return false;

        lock.lock();  // ← Thread waits here if another thread is inside
        try {
            // ── Critical Section (only ONE thread runs this at a time) ──
            int current = stock.getOrDefault(productId, 0);
            System.out.printf(
                "[%s] Checking stock for '%s': available=%d, requested=%d%n",
                Thread.currentThread().getName(), productId, current, qty
            );

            if (current < qty) {
                System.out.printf(
                    "[%s] ❌ STOCK FAILED for '%s' — not enough stock%n",
                    Thread.currentThread().getName(), productId
                );
                return false;
            }

            stock.put(productId, current - qty);
            System.out.printf(
                "[%s] ✅ RESERVED %d of '%s' — remaining stock: %d%n",
                Thread.currentThread().getName(), productId, qty,
                stock.get(productId)
            );
            return true;
            // ──────────────────────────────────────────────────────────────
        } finally {
            lock.unlock(); // ← ALWAYS releases, even if exception thrown
        }
    }

    /**
     * TryLock variant — does NOT block. Returns false immediately if busy.
     * Useful for non-critical paths (e.g., preview stock check).
     */
    public boolean tryReserveStock(String productId, int qty) {
        ReentrantLock lock = locks.get(productId);
        if (lock == null) return false;

        boolean acquired = lock.tryLock(); // non-blocking attempt
        if (!acquired) {
            System.out.printf(
                "[%s] ⚠ Could not acquire lock for '%s' — skipping%n",
                Thread.currentThread().getName(), productId
            );
            return false;
        }

        try {
            int current = stock.getOrDefault(productId, 0);
            if (current < qty) return false;
            stock.put(productId, current - qty);
            return true;
        } finally {
            lock.unlock();
        }
    }

    public int getStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }
}
