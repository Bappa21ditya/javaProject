package com.security.java_project.system_design.inventory.observer;

import com.security.java_project.system_design.inventory.entity.Order;

/**
 * Concrete Observer — sends Email notifications.
 */
public class EmailNotificationObserver implements OrderObserver {

    private final String emailAddress;

    public EmailNotificationObserver(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void onOrderEvent(Order order, String eventType) {
        System.out.println(
                "[EMAIL → " + emailAddress + "] "
                + "Order " + order.getOrderId()
                + " | Event: " + eventType
                + " | Status: " + order.getStatus()
                + " | Payment: " + order.getPayment().getStatus());
    }
}
