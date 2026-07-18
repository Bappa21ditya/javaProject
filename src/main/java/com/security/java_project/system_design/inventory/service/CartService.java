package com.security.java_project.system_design.inventory.service;

import com.security.java_project.system_design.inventory.entity.Product;
import com.security.java_project.system_design.inventory.entity.User;

public class CartService {

    public void addToCart(
            User user,
            Product product,
            int quantity) {

        user.getCart()
                .addProduct(product,
                        quantity);
    }

    public double getCartTotal(
            User user) {

        return user.getCart()
                .getTotalAmount();
    }
}
