package com.security.java_project.system_design.MyList.inventory.observer;

import com.security.java_project.system_design.MyList.inventory.entity.Order;

/**
 * Observer interface for the Observer Pattern.
 * Any notification channel (Email, SMS, Push) must implement this.
 */
public interface OrderObserver {
    void onOrderEvent(Order order, String eventType);
}
