package com.security.java_project.threading.BankAccount;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class BankAccountDemoForkJoinPool {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        // ✅ Create ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool(3);

        // ✅ Run tasks using CompletableFuture + ForkJoinPool
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            int newBalance = account.deposit(500);
            System.out.println(Thread.currentThread().getName() +
                    " Deposited 500, Balance: " + newBalance);
        }, pool);

        CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> {
            int newBalance = account.withdraw(300);
            System.out.println(Thread.currentThread().getName() +
                    " Withdrew 300, Balance: " + newBalance);
        }, pool);

        // ✅ Wait for all tasks
        CompletableFuture.allOf(f1, f2).join();

        // ✅ Shutdown pool
        pool.shutdown();

        System.out.println("Final Balance: " + account.getBalance());
    }
}
