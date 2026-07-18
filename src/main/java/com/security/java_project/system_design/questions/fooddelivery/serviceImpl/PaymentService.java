package com.security.java_project.system_design.questions.fooddelivery.serviceImpl;

import com.security.java_project.system_design.questions.fooddelivery.strategy.PaymentStrategy;

public class PaymentService {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy)
    {
        this.paymentStrategy=paymentStrategy;
    }

    public void makePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}
