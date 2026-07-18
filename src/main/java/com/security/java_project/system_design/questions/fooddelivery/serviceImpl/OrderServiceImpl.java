package com.security.java_project.system_design.questions.fooddelivery.serviceImpl;

import com.security.java_project.system_design.questions.fooddelivery.entity.*;
import com.security.java_project.system_design.questions.fooddelivery.enums.OrderStatus;
import com.security.java_project.system_design.questions.fooddelivery.servics.OrderService;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

//    Create Order
//Loop through CartItems
//For every CartItem
//Create OrderItem
//Copy MenuItem
//Copy Quantity
//Copy Price
//Add OrderItem to Order


//User clicks Checkout
//createOrder()
//Order Status = CREATED
//generateBill()
//pay()
//placeOrder()
//Order Status = CONFIRMED
//assignPartner()
//PREPARING
//READY
//PICKED_UP
//DELIVERED





    //The system creates an order.
    //Calculates the bill.
    //Processes payment.
    //Places the order with the restaurant.
    //Assigns a delivery partner.

    private List<OrderItem> orderItems = new ArrayList<>();

    @Override
    public Order createOrder(User user, Cart cart) {

        Order order=new Order(user);
        for(CartItem cartItem:cart.getCartItems())
        {
            OrderItem orderItem=new OrderItem();

            orderItem.setMenuItem(cartItem.getMenuItem());

            orderItem.setQuantity(cartItem.getQuantity());

            orderItem.setPrice(cartItem.getMenuItem().getPrice());

            order.getOrderItems().add(orderItem);
        }
        return order;
    }

    @Override
    public Bill generateBill(Order order) {
        Bill bill=new Bill();
       double total=calculateToTalPrice(order);
       bill.setItemTotal(total);
        return bill;
    }


//Verify payment succeeded
//Change status to CONFIRMED
//Add the order to the restaurant's active orders
//Notify the restaurant (later)
    @Override
    public void placeOrder(Order order) {

    }

    @Override
    public void updateStatus(Order order, OrderStatus status) {
        order.setStatus(status);

    }
    double calculateToTalPrice(Order order)
    {
        double total=0.0;
        for (OrderItem orderItem:order.getOrderItems())
        {
            total+=orderItem.getPrice()* orderItem.getQuantity();
        }

        return total;
    }

}

//FoodDeliveryService.checkout()
//        │
//        ▼
//OrderService.createOrder()
//        │
//        ▼
//PaymentService.pay()
//        │
//        ▼
//OrderService.placeOrder()
//        │
//        ▼
//RestaurantService.acceptOrder()
//        │
//        ▼
//OrderStatus = CONFIRMED
//        │
//Restaurant prepares food
//        │
//        ▼
//OrderStatus = PREPARING
//        │
//        ▼
//OrderStatus = READY
//        │
//        ▼
//DeliveryPartnerService.assignPartner()
//        │
//        ▼
//DeliveryPartnerService.pickUp()
//        │
//        ▼
//OrderStatus = PICKED_UP
//        │
//        ▼
//DeliveryPartnerService.deliver()
//        │
//        ▼
//OrderStatus = DELIVERED
//        │
//        ▼
//OrderStatus = COMPLETED
