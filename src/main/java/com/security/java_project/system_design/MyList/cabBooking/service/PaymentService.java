package com.security.java_project.system_design.MyList.cabBooking.service;

import com.security.java_project.system_design.MyList.cabBooking.strategy.PaymentStrategy;


public interface PaymentService {
    public boolean processPayment(double amount, PaymentStrategy strategy);
}
