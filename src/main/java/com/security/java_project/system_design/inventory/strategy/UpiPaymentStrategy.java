package com.security.java_project.system_design.inventory.strategy;

public class UpiPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean pay(double amount) {

        System.out.println(
                "Processing UPI Payment : ₹"
                        + amount);

        return true;
    }
}
