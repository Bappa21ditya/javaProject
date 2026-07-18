package com.security.java_project.system_design.questions.fooddelivery.serviceImpl;

import com.security.java_project.system_design.questions.fooddelivery.entity.Cart;
import com.security.java_project.system_design.questions.fooddelivery.entity.CartItem;
import com.security.java_project.system_design.questions.fooddelivery.entity.MenuItem;
import com.security.java_project.system_design.questions.fooddelivery.servics.CartService;

import java.util.Iterator;

public class CartServiceImpl implements CartService {

    // cartItem class (menuItem,quantity,price),cart=(user,id,restaurant,cartItem)
//User
// │
// └── Cart
//      │
//      └── List<CartItem>


//    @Override
//    public void addItem(Cart cart, MenuItem item, int quantity) {
//        CartItem cartItem = new CartItem(
//                item,
//                quantity);
//        cart.getCartItems().add(cartItem);
//
//
//    }

    @Override
    public void addItem(Cart cart, MenuItem item, int quantity) {

        // If the item already exists, increase the quantity
        for (CartItem cartItem : cart.getCartItems()) {
            if (cartItem.getMenuItem().getId() == item.getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                return;
            }
        }

        // Otherwise, add a new CartItem
        CartItem cartItem = new CartItem(item, quantity);
        cart.getCartItems().add(cartItem);
    }

    @Override
    public void removeItem(Cart cart, MenuItem item) {

        Iterator<CartItem> iterator = cart.getCartItems().iterator();

        while (iterator.hasNext()) {
            CartItem cartItem = iterator.next();

            if (cartItem.getMenuItem().getId() == item.getId()) {
                iterator.remove();
                return;
            }
        }
    }

    @Override
    public void viewCart(Cart cart) {

        if (cart.getCartItems().isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("------ Cart ------");

        double total = 0;

        for (CartItem cartItem : cart.getCartItems()) {

            double price = cartItem.getMenuItem().getPrice();
            double itemTotal = price * cartItem.getQuantity();

            total += itemTotal;

            System.out.println(
                    cartItem.getMenuItem().getName()
                            + " | Qty: " + cartItem.getQuantity()
                            + " | Price: ₹" + price
                            + " | Total: ₹" + itemTotal
            );
        }

        System.out.println("------------------");
        System.out.println("Grand Total: ₹" + total);
    }

    @Override
    public void clearCart(Cart cart) {
        cart.getCartItems().clear();
    }


}
