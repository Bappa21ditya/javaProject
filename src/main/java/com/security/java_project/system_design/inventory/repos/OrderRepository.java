package com.security.java_project.system_design.inventory.repos;

import com.security.java_project.system_design.inventory.entity.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {
    private final Map<String, Order>
            orders =
            new HashMap<>();

    public void save(
            Order order) {

        orders.put(
                order.getOrderId(),
                order);
    }

    public Order findById(
            String orderId) {

        return orders.get(
                orderId);
    }

    public List<Order> findAll() {

        return new ArrayList<>(
                orders.values());
    }

    public void delete(
            String orderId) {

        orders.remove(
                orderId);
    }
}
