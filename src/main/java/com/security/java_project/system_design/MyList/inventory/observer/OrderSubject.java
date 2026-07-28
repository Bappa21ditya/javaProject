package com.security.java_project.system_design.MyList.inventory.observer;

import com.security.java_project.system_design.MyList.inventory.entity.Order;

/**
 * Subject (Observable) interface.
 * OrderService will implement this to manage subscribers.
 */
public interface OrderSubject {
    void addObserver(OrderObserver observer);
    void removeObserver(OrderObserver observer);
    void notifyObservers(Order order, String eventType);
}
