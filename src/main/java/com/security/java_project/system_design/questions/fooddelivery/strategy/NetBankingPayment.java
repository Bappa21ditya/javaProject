package com.security.java_project.system_design.questions.fooddelivery.strategy;

import  com.security.java_project.system_design.questions.fooddelivery.strategy.PaymentStrategy;

public class NetBankingPayment implements PaymentStrategy {
    private String bank;

    public NetBankingPayment(String bank) {
        this.bank = bank;
    }

    @Override
    public void pay(double amount) {
        System.out.println(
                "Paid ₹" + amount + " using NetBanking (" + bank + ")"
        );
    }
}
