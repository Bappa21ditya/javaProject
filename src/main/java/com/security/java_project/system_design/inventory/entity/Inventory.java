package com.security.java_project.system_design.inventory.entity;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Inventory {

    private ConcurrentHashMap<String,Integer> stock=new ConcurrentHashMap<>();

    public void addStock(String productId,
                         int quantity)
    {
       stock.merge(productId,quantity,Integer::sum);

       // same as this
//        if(stock.containsKey(productId)) {
//            stock.put(productId,
//                    stock.get(productId) + quantity);
//        } else {
//            stock.put(productId, quantity);
//        }
    }

    /**
     * ⚠ BUG IN ORIGINAL CODE (kept here for learning):
     *   The original code did:
     *     Integer current = stock.get(productId);   // read
     *     if (current >= qty)
     *         stock.put(productId, current - qty);  // write
     *
     *   ConcurrentHashMap makes individual get/put thread-safe,
     *   BUT the gap between get() and put() is NOT atomic.
     *   Two threads can BOTH read stock=1, BOTH pass the if-check,
     *   and BOTH decrement → stock goes to -1 (OVERSELL!).
     *
     * FIX: Use compute() which locks the BUCKET for the key atomically,
     *      making the entire read-check-write a single atomic operation.
     */
    public boolean reserveStock(String productId, int quantity) {
        // AtomicBoolean-style trick: use a single-element array to capture
        // the result from inside the lambda (lambdas can't modify local vars)
        final boolean[] success = { false };

        stock.compute(productId, (key, current) -> {
            if (current == null || current < quantity) {
                // Not enough stock — do NOT modify, return same value
                success[0] = false;
                return current;
            }
            success[0] = true;
            return current - quantity; // atomic decrement
        });

        return success[0];
    }
    public Integer getStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }

    }
