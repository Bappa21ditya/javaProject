package com.security.java_project.system_design.questions.fooddelivery.entity;

import com.security.java_project.system_design.questions.fooddelivery.enums.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderItem> orderItems = new ArrayList<>();

    private long id;

    private User user;

    private Restaurant restaurant;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Order(User user) {
        this.user = user;
    }

    public DeliveryPartner getDeliveryPartner() {
        return deliveryPartner;
    }

    public void setDeliveryPartner(DeliveryPartner deliveryPartner) {
        this.deliveryPartner = deliveryPartner;
    }

    public long getId() {
        return id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(long id) {
        this.id = id;
    }

    private DeliveryPartner deliveryPartner;

    private Payment payment;

    private Bill bill;

    private OrderStatus status;
}
