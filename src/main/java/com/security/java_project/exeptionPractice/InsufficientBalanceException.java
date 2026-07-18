package com.security.java_project.exeptionPractice;

public class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}
