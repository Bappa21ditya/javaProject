package com.security.java_project.system_design.inventory.observer;

import com.security.java_project.system_design.inventory.entity.Order;

/**
 * Concrete Observer — sends in-app Push notifications.
 */
public class PushNotificationObserver implements OrderObserver {

    private final String deviceToken;

    public PushNotificationObserver(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    @Override
    public void onOrderEvent(Order order, String eventType) {
        System.out.println(
                "[PUSH → " + deviceToken + "] "
                + "Order " + order.getOrderId()
                + " | Event: " + eventType
                + " | Warehouse: " + order.getWarehouse().getWarehouseName());
    }
}
