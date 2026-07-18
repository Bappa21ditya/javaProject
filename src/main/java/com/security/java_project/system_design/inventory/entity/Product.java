package com.security.java_project.system_design.inventory.entity;

public class Product {
    private String productId;
    private String name;
    private double price;
    private Category category;

    public Product(String productId,
                   String name,
                   double price,
                   Category category) {

        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
