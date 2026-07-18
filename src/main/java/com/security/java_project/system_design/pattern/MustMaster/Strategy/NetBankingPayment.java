package com.security.java_project.system_design.pattern.MustMaster.Strategy;

public class NetBankingPayment implements PaymentStrategy {
    private String bank;

    public NetBankingPayment(String bank) {
        this.bank = bank;
    }

    @Override
    public void pay(int amount) {
        System.out.println(
                "Paid ₹" + amount + " using NetBanking (" + bank + ")"
        );
    }
}
