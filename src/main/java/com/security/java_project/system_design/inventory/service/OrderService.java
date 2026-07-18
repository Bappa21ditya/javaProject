package com.security.java_project.system_design.inventory.service;

import com.security.java_project.system_design.inventory.entity.*;
import com.security.java_project.system_design.inventory.observer.OrderObserver;
import com.security.java_project.system_design.inventory.observer.OrderSubject;
import com.security.java_project.system_design.inventory.repos.OrderRepository;
import com.security.java_project.system_design.inventory.strategy.PaymentStrategy;
import com.security.java_project.system_design.inventory.strategy.WarehouseSelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements OrderSubject {
    private final OrderRepository orderRepository;
    private final WarehouseService warehouseService;
    private final PaymentService paymentService;
    private final InvoiceService invoiceService;

    // Observer Pattern: list of notification subscribers
    private final List<OrderObserver> observers = new ArrayList<>();

    public OrderService(
            OrderRepository orderRepository,
            WarehouseService warehouseService,
            PaymentService paymentService,
            InvoiceService invoiceService) {

        this.orderRepository = orderRepository;
        this.warehouseService = warehouseService;
        this.paymentService = paymentService;
        this.invoiceService = invoiceService;
    }

    // ── Observer Pattern methods ──────────────────────────────────────────────

    @Override
    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Order order, String eventType) {
        for (OrderObserver observer : observers) {
            observer.onOrderEvent(order, eventType);
        }
    }

    // ─────────────────────────────────────────────────────────────────────────

    public Order checkout(
            String orderId,
            User user,
            Address address,
            PaymentStrategy paymentStrategy,
            WarehouseSelectionStrategy warehouseStrategy) {

        double total =
                user.getCart()
                        .getTotalAmount();

        boolean paymentSuccess =
                paymentService.processPayment(
                        total,
                        paymentStrategy);

        Payment payment =
                new Payment(
                        "PAY-" + orderId,
                        total);

        if(paymentSuccess) {
            payment.markSuccess();
        } else {
            payment.markFailed();
        }

        Warehouse warehouse =
                warehouseStrategy.selectWarehouse(
                        warehouseService
                                .getAllWarehouses(),
                        convertCart(user));

        Invoice invoice =
                invoiceService
                        .generateInvoice(
                                "INV-" + orderId,
                                total);

        List<OrderItem> orderItems =
                new ArrayList<>();

        user.getCart()
                .getCartItems()
                .values()
                .forEach(item ->
                        orderItems.add(
                                new OrderItem(
                                        item.getProduct(),
                                        item.getQuantity()
                                )));

        Order order =
                new Order(
                        orderId,
                        user,
                        warehouse,
                        address,
                        orderItems,
                        payment,
                        invoice);

        orderRepository.save(order);

        user.addOrder(order);

        user.getCart().clear();

        // Notify all registered observers about ORDER_PLACED event
        notifyObservers(order, "ORDER_PLACED");

        return order;
    }

    private java.util.Map<Product,Integer>
    convertCart(User user) {

        java.util.Map<Product,Integer>
                map = new java.util.HashMap<>();

        user.getCart()
                .getCartItems()
                .values()
                .forEach(item ->
                        map.put(
                                item.getProduct(),
                                item.getQuantity()));

        return map;
    }
}
