package com.security.java_project.system_design.inventory.entity;

public class Invoice {
    private String invoiceId;

    private double totalAmount;

    public Invoice(String invoiceId,
                   double totalAmount) {

        this.invoiceId = invoiceId;
        this.totalAmount = totalAmount;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
