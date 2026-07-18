package com.security.java_project.system_design.questions.fooddelivery.entity;

public class CartItem {

    private long id;

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    private MenuItem menuItem;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public CartItem(MenuItem menuItem, int quantity) {
        this.menuItem=menuItem;
        this.quantity=quantity;
    }

    private int quantity;
}
