package com.security.java_project.system_design.inventory.observer;

import com.security.java_project.system_design.inventory.entity.Order;

/**
 * Concrete Observer — sends SMS notifications.
 */
public class SmsNotificationObserver implements OrderObserver {

    private final String phoneNumber;

    public SmsNotificationObserver(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void onOrderEvent(Order order, String eventType) {
        System.out.println(
                "[SMS → " + phoneNumber + "] "
                + "Order " + order.getOrderId()
                + " | Event: " + eventType
                + " | Status: " + order.getStatus());
    }
}
