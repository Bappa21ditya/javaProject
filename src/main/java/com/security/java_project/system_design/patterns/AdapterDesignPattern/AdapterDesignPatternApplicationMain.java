package com.security.java_project.system_design.patterns.AdapterDesignPattern;

public class AdapterDesignPatternApplicationMain {

    public static void main(String[] args) {

        // Third-party object
        Razorpay razorpay = new Razorpay();

        // Adapter
        PaymentGateway paymentGateway =
                new RazorpayAdapter(razorpay);

        // Client calls only pay()
        paymentGateway.pay(5000);

    }
}
