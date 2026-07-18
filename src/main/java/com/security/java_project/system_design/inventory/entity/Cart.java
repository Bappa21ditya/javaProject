package com.security.java_project.system_design.inventory.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private String cartId;

    private Map<String, CartItem> cartItems =
            new HashMap<>();

    public Cart(String cartId) {
        this.cartId = cartId;
    }
//    This method is implementing the common cart behavior:
//    If the product is already in the cart, increase its quantity.
//    Otherwise, create a new cart item.

    public void addProduct(Product product,
                           int quantity) {
        if(cartItems.containsKey(
                product.getProductId())) {

            cartItems.get(
                            product.getProductId())
                    .addQuantity(quantity);

            return;
        }

        cartItems.put(
                product.getProductId(),
                new CartItem(product,
                        quantity));
    }
    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    public void clear() {
        cartItems.clear();
    }

    public double getTotalAmount() {

        return cartItems.values()
                .stream()
                .mapToDouble(
                        CartItem::getTotalPrice)
                .sum();
    }
}
