package com.security.java_project.system_design.simple_inventory;

public class InventoryItem {

    private Product product;
    private int stock;

    public InventoryItem(
            Product product,
            int stock) {

        this.product = product;
        this.stock = stock;
    }

    public Product getProduct() {
        return product;
    }

    public int getStock() {
        return stock;
    }

    public void addStock(int qty) {
        stock += qty;
    }

    public void reduceStock(int qty) {
        stock -= qty;
    }


}
