package com.security.java_project.threading.BankAccount;

import java.util.concurrent.Callable;

public class TransactionalTaskCallable implements Callable<String>

    {
        private BankAccount account;
        private String type;
        private int amount;

    public TransactionalTaskCallable(BankAccount account, String type, int amount) {
            this.account = account;
            this.type = type;
            this.amount = amount;
        }

        @Override
        public String call() {
            if (type.equals("deposit")) {
                int newBalance = account.deposit(amount);
                return "Deposited " + amount + ", Balance: " + newBalance;
            } else {
                int newBalance = account.withdraw(amount);
                return "Withdrew " + amount + ", Balance: " + newBalance;
            }
        }
    }
