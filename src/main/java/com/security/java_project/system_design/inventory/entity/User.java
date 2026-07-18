package com.security.java_project.system_design.inventory.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;

    private Cart cart;

    private List<Order> orders =
            new ArrayList<>();

    public User(String userId,
                String name) {

        this.userId = userId;
        this.name = name;
        this.cart =
                new Cart("CART-" + userId);
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
