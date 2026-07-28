package com.security.java_project.system_design.MyList.inventory.service;

import com.security.java_project.system_design.MyList.inventory.strategy.PaymentStrategy;

public class PaymentService {

    public boolean processPayment(
            double amount,
            PaymentStrategy strategy) {

        return strategy.pay(amount);
    }
}
