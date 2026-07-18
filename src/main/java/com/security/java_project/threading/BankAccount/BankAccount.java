package com.security.java_project.threading.BankAccount;

public class BankAccount {
    private int balance = 1000;

    public synchronized int deposit(int amount)
    {
        balance+=amount;
        return balance;
    }
    public synchronized int withdraw(int amount)
    {
        if(balance>=amount)
        {
            balance-=amount;
        }
        return balance;
    }
    public int getBalance()
    {
        return balance;
    }



}
