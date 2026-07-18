package com.security.java_project.system_design.questions.fooddelivery.strategy;


public class CreditCardPayment implements PaymentStrategy {

    String cradNumber;

   public CreditCardPayment(String cardNumber)
    {
        this.cradNumber=cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println(
                "Paid ₹" + amount + " using Credit Card " + cradNumber
        );
    }
}
