package com.security.java_project.threading.BankAccount;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankAccountDemoCompetableFeature {
    public static void main(String[] args) throws Exception {

        BankAccount account = new BankAccount();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Async deposit
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            int newBalance = account.deposit(500);
            System.out.println("Deposited 500, Balance: " + newBalance);
        }, executor);

        // Async withdraw
        CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> {
            int newBalance = account.withdraw(300);
            System.out.println("Withdrew 300, Balance: " + newBalance);
        }, executor);

        // Wait for both tasks
        CompletableFuture.allOf(f1, f2).join();

        executor.shutdown();

        System.out.println("Final Balance: " + account.getBalance());
    }
}
