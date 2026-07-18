package com.security.java_project.system_design.questions.fooddelivery.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private long id;

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    private User user;

    private Restaurant restaurant;

    private List<CartItem> cartItems=new ArrayList<>();
}
