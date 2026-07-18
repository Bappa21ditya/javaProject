package com.security.java_project.system_design.parkingLot.serviceImpl;

import com.security.java_project.system_design.parkingLot.strategy.PaymentStrategy;

public class PaymentService
{
    public boolean processPayment(double amount, PaymentStrategy strategy) {
        return strategy.pay(amount);
    }
}
