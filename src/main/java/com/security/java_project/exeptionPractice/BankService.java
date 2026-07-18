package com.security.java_project.exeptionPractice;

import java.util.HashMap;

public class BankService {
    HashMap<String,BankAccount> accounts=new HashMap<>();

    public void createAccount(String accountNumber, double initialBalance)
    {
        accounts.put(accountNumber,new BankAccount(accountNumber,initialBalance));
    }
    public BankAccount getAccount(String accNo) throws Exception
    {
        BankAccount acc = accounts.get(accNo);
        if (acc == null) {
            throw new Exception("Account not found");
        }
        return acc;
    }



}
