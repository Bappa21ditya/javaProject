package com.security.java_project.system_design.inventory.entity;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product,
                    int quantity) {

        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int qty) {
        this.quantity += qty;
    }

    public double getTotalPrice() {
        return quantity * product.getPrice();
    }
}
