package com.security.java_project.threading.BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BankAccountDemo {
    public static void main(String[] args) throws Exception {

        BankAccount account = new BankAccount();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // runabble
//        executor.submit(() -> {
//            new TransactionTask(account, "deposit", 500).run();
//        });
//        executor.submit(() -> {
//            new TransactionTask(account, "withdraw", 500).run();
//        });

       // executor.submit(new TransactionTask(account, "deposit", 500));
       // executor.submit(new TransactionTask(account, "withdraw", 500));
       // executor.shutdown();
// callable
//        List<Future<String>> futures = new ArrayList<>();
//
//        futures.add(executor.submit(new TransactionalTaskCallable(account, "deposit", 500)));
//        futures.add(executor.submit(new TransactionalTaskCallable(account, "withdraw", 300)));
//        futures.add(executor.submit(new TransactionalTaskCallable(account, "withdraw", 700)));
//
//        for (Future<String> f : futures) {
//            System.out.println(f.get());
//        }
//
//        executor.shutdown();
//
//        System.out.println("Final Balance: " + account.getBalance());
//    }

        // Submit tasks using lambda (NO Runnable/Callable class)
        Future<?> f1 = executor.submit(() -> {
            int newBalance = account.deposit(500);
            System.out.println("Deposited 500, Balance: " + newBalance);
        });

        Future<?> f2 = executor.submit(() -> {
            int newBalance = account.withdraw(300);
            System.out.println("Withdrew 300, Balance: " + newBalance);
        });

        Future<?> f3 = executor.submit(() -> {
            int newBalance = account.withdraw(700);
            System.out.println("Withdrew 700, Balance: " + newBalance);
        });

        // Wait for all tasks to complete
        f1.get();
        f2.get();
        f3.get();

        executor.shutdown();

        System.out.println("Final Balance: " + account.getBalance());
    }
}

