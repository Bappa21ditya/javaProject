package com.security.java_project.system_design.questions.fooddelivery.entity;

public class OrderItem {
    private long id;

    private MenuItem menuItem;

    private int quantity;



    public long getId() {
        return id;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public void setId(long id) {
        this.id = id;
    }

    private double price;
}
