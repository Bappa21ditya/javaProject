package com.security.java_project.system_design.pattern.MustMaster.Strategy;

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
