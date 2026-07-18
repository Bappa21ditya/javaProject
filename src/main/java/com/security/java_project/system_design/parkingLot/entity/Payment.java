package com.security.java_project.system_design.parkingLot.entity;
import com.security.java_project.system_design.parkingLot.enums.PaymentType;

public class Payment {
    private int id;
    private double amount;
    private PaymentType paymentType;

    public Payment(int id, double amount, PaymentType paymentType) {
        this.id = id;
        this.amount = amount;
        this.paymentType = paymentType;
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

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
