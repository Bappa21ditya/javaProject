package com.security.java_project.system_design.cabBooking.strategy;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println(
                "Processing Credit Card Payment : ₹"
                        + amount);

        return true;
    }
}
