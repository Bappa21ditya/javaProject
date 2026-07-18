package com.security.java_project.system_design.inventory.entity;

import com.security.java_project.system_design.inventory.enums.OrderStatus;

import java.util.List;

public class Order {
    private String orderId;

    private User user;

    private Warehouse warehouse;

    private Address deliveryAddress;

    private List<OrderItem> orderItems;

    private Payment payment;

    private Invoice invoice;

    private OrderStatus status;

    public Order(String orderId,
                 User user,
                 Warehouse warehouse,
                 Address deliveryAddress,
                 List<OrderItem> orderItems,
                 Payment payment,
                 Invoice invoice) {

        this.orderId = orderId;
        this.user = user;
        this.warehouse = warehouse;
        this.deliveryAddress = deliveryAddress;
        this.orderItems = orderItems;
        this.payment = payment;
        this.invoice = invoice;

        this.status =
                OrderStatus.CREATED;
    }

    public String getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Payment getPayment() {
        return payment;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void updateStatus(
            OrderStatus status) {

        this.status = status;

    }
}
