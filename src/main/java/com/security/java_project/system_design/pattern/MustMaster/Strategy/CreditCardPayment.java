package com.security.java_project.system_design.pattern.MustMaster.Strategy;

public class CreditCardPayment implements PaymentStrategy {

    String cradNumber;

    CreditCardPayment(String cardNumber)
    {
        this.cradNumber=cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println(
                "Paid ₹" + amount + " using Credit Card " + cradNumber
        );
    }
}
