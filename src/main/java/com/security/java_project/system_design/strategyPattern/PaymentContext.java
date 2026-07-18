package com.security.java_project.system_design.strategyPattern;

public class PaymentContext {
    private Strategy paymentStrategy;

    PaymentContext(Strategy paymentStrategy)
    {
        this.paymentStrategy=paymentStrategy;
    }

    void makePayment(int val)
    {
        paymentStrategy.pay();
    }


}
