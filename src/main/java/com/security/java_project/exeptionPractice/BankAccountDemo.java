package com.security.java_project.exeptionPractice;

public class BankAccountDemo {
    public static void main(String[] args) {

        BankService bank=new BankService();
        bank.createAccount("123",1000);

        try {
            BankAccount acc=bank.getAccount("123");
            acc.deposit(500);
            acc.withdraw(2000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Business Error: " + e.getMessage());
            Logger.log("Business Error: " + e.getMessage());

        } catch (InvalidAmountException e) {
            System.out.println("Invalid Input: " + e.getMessage());
            Logger.log("Invalid Input: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
            Logger.log("General Error: " + e.getMessage());

        } finally {
            System.out.println("Transaction attempt finished.");
        }
    }
    }
