package com.security.java_project.system_design.inventory.service;

import com.security.java_project.system_design.inventory.strategy.PaymentStrategy;

public class PaymentService {

    public boolean processPayment(
            double amount,
            PaymentStrategy strategy) {

        return strategy.pay(amount);
    }
}
