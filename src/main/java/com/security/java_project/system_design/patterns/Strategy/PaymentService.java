package com.security.java_project.system_design.patterns.Strategy;

public class PaymentService {
    private  PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy)
    {
        this.paymentStrategy=paymentStrategy;
    }
    public void makePayment(int amount) {
        paymentStrategy.pay(amount);
    }
}
