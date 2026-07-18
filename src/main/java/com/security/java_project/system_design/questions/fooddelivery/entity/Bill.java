package com.security.java_project.system_design.questions.fooddelivery.entity;

public class Bill {
    private long id;

    private double itemTotal;

    private double deliveryCharge;

    private double tax;

    private double discount;

    public long getId() {
        return id;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(double deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }

    public void setId(long id) {
        this.id = id;
    }

    private double grandTotal;



}
