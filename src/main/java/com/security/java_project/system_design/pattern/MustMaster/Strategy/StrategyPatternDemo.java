package com.security.java_project.system_design.pattern.MustMaster.Strategy;

public class StrategyPatternDemo {
    public static void main(String[] args) {

        PaymentService service = new PaymentService();
// Credit Card payment
        service.setPaymentStrategy(
                new CreditCardPayment("1234-5678-9999"));
        service.makePayment(500);
        // UPI payment
        service.setPaymentStrategy(
                new UPIPayment("rahul@upi")
        );
        service.makePayment(300);

        // Net banking
        service.setPaymentStrategy(
                new NetBankingPayment("HDFC")
        );
        service.makePayment(500);
    }

}
//main()
//  |
//          ↓
//PaymentService created
//  |
//          ↓
//Strategy object created by new
//  |
//          ↓
//Strategy injected into service
//  |
//          ↓
//makePayment()
//  |
//          ↓
//          paymentStrategy.pay()
//  |
//          ↓
//          ConcreteStrategy.pay()

