package com.security.java_project.system_design.cabBooking.serviceImpl;

import com.security.java_project.system_design.cabBooking.strategy.PaymentStrategy;
import com.security.java_project.system_design.cabBooking.service.PaymentService;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public boolean processPayment(double amount, PaymentStrategy strategy) {
        return strategy.pay(amount);
    }
}
