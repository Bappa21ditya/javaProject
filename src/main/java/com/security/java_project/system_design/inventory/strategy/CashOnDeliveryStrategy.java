package com.security.java_project.system_design.inventory.strategy;

public class CashOnDeliveryStrategy implements PaymentStrategy{
    @Override
    public boolean pay(double amount) {

        System.out.println(
                "Cash On Delivery Selected : ₹"
                        + amount);

        return true;
    }
}
