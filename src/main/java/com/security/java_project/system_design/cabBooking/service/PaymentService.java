package com.security.java_project.system_design.cabBooking.service;

import com.security.java_project.system_design.cabBooking.strategy.PaymentStrategy;


public interface PaymentService {
    public boolean processPayment(double amount, PaymentStrategy strategy);
}
