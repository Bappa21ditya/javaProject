package com.security.java_project.system_design.inventory.entity;
import com.security.java_project.system_design.inventory.enums.PaymentStatus;

public class Payment {
    private String paymentId;

    private double amount;

    private PaymentStatus status;

    public Payment(String paymentId,
                   double amount) {

        this.paymentId = paymentId;
        this.amount = amount;
        this.status =
                PaymentStatus.PENDING;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void markSuccess() {
        status = PaymentStatus.SUCCESS;
    }

    public void markFailed() {
        status = PaymentStatus.FAILED;
    }
}
