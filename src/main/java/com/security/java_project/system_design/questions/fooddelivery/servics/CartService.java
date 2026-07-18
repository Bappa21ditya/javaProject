package com.security.java_project.system_design.questions.fooddelivery.servics;

import com.security.java_project.system_design.questions.fooddelivery.entity.Cart;
import com.security.java_project.system_design.questions.fooddelivery.entity.MenuItem;

public interface CartService {


    public void addItem(Cart cart, MenuItem item, int quantity);

    public void removeItem(Cart cart, MenuItem item);

    public void viewCart(Cart cart);

    public void clearCart(Cart cart);

}
