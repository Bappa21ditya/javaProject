package com.security.java_project.exeptionPractice;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if(amount<=0)
        {
            throw new InvalidAmountException("Amount must be greater than 0");
        }
        balance+=amount;
    };
    public void withdraw(double amount) throws InsufficientBalanceException {
        if(amount<=0)
        {
            throw new InvalidAmountException("Amount must be greater than 0");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Not enough balance");
        }
        balance-=amount;
    }
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

}
