package com.security.java_project.system_design.cabBooking.entity;

public class Payment {

    private int id;

    private double amount;

    private boolean paymentSuccess;

    public Payment() {
    }

    public Payment(int id,
                   double amount,
                   boolean paymentSuccess) {
        this.id = id;
        this.amount = amount;
        this.paymentSuccess = paymentSuccess;
    }
    public Payment(double amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }



    public boolean isPaymentSuccess() {
        return paymentSuccess;
    }

    public void setPaymentSuccess(boolean paymentSuccess) {
        this.paymentSuccess = paymentSuccess;
    }
}
