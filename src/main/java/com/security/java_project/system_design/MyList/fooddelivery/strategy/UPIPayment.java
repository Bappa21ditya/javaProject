package com.security.java_project.system_design.MyList.fooddelivery.strategy;

public class UPIPayment implements PaymentStrategy {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println(
                "Paid ₹" + amount + " using UPI " + upiId
        );
    }
}
