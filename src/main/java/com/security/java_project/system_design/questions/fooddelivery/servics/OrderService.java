package com.security.java_project.system_design.questions.fooddelivery.servics;
import com.security.java_project.system_design.questions.fooddelivery.entity.Cart;
import com.security.java_project.system_design.questions.fooddelivery.entity.Order;
import com.security.java_project.system_design.questions.fooddelivery.entity.Bill;
import com.security.java_project.system_design.questions.fooddelivery.entity.User;
import com.security.java_project.system_design.questions.fooddelivery.enums.OrderStatus;

public interface OrderService {

    public Order createOrder(User user, Cart cart);

    public Bill generateBill(Order order);

    public void placeOrder(Order order);

    public void updateStatus(Order order, OrderStatus status);
}
