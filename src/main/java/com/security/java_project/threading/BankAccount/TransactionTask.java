package com.security.java_project.threading.BankAccount;

public class TransactionTask implements Runnable{
    private BankAccount account;
    private String type;
    private int amount;

    public TransactionTask(BankAccount account, String type, int amount) {
        this.account = account;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public void run() {
        if(type.equals("deposit")){
            int newBalance = account.deposit(amount);
        System.out.println("Deposited " + amount + ", Balance: " + newBalance);
    } else {
        int newBalance = account.withdraw(amount);
        System.out.println("Withdrew " + amount + ", Balance: " + newBalance);
    }
    }
}
