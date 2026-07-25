package com.security.java_project.system_design.AdapterDesignPattern;

public class RazorpayAdapter implements PaymentGateway{

    private Razorpay razorpay;

    public RazorpayAdapter(Razorpay razorpay) {
        this.razorpay = razorpay;
    }

    @Override
    public void pay(double amount) {

        System.out.println("Adapter is converting pay() into makePayment()");

        razorpay.makePayment(amount);

    }
}
