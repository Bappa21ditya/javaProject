package com.security.java_project.system_design.pattern.MustMaster.Strategy;

public class UPIPayment implements PaymentStrategy {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(int amount) {
        System.out.println(
                "Paid ₹" + amount + " using UPI " + upiId
        );
    }
}
