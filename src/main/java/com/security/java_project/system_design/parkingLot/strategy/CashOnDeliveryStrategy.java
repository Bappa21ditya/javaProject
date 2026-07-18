package com.security.java_project.system_design.parkingLot.strategy;
import com.security.java_project.system_design.parkingLot.strategy.PaymentStrategy;

public class CashOnDeliveryStrategy implements PaymentStrategy{
    @Override
    public boolean pay(double amount) {

        System.out.println(
                "Processing Cash on Delivery : ₹"
                        + amount);

        return true;
    }
}
