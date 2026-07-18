package com.security.java_project.system_design.inventory;

import com.security.java_project.system_design.inventory.entity.*;
import com.security.java_project.system_design.inventory.repos.OrderRepository;
import com.security.java_project.system_design.inventory.repos.ProductRepository;
import com.security.java_project.system_design.inventory.repos.UserRepository;
import com.security.java_project.system_design.inventory.repos.WarehouseRepository;
import com.security.java_project.system_design.inventory.service.*;
import com.security.java_project.system_design.inventory.strategy.NearestWarehouseStrategy;
import com.security.java_project.system_design.inventory.strategy.UpiPaymentStrategy;
import com.security.java_project.system_design.inventory.observer.EmailNotificationObserver;
import com.security.java_project.system_design.inventory.observer.SmsNotificationObserver;
import com.security.java_project.system_design.inventory.observer.PushNotificationObserver;

public class InventoryMain {
    public static void main(String[] args) {

        UserRepository userRepo =
                new UserRepository();

        ProductRepository productRepo =
                new ProductRepository();

        WarehouseRepository warehouseRepo =
                new WarehouseRepository();

        OrderRepository orderRepo =
                new OrderRepository();

        UserService userService =
                new UserService(userRepo);

        ProductService productService =
                new ProductService(productRepo);

        WarehouseService warehouseService =
                new WarehouseService(warehouseRepo);

        CartService cartService =
                new CartService();

        PaymentService paymentService =
                new PaymentService();

        InvoiceService invoiceService =
                new InvoiceService();

        OrderService orderService =
                new OrderService(
                        orderRepo,
                        warehouseService,
                        paymentService,
                        invoiceService);

        Category electronics =
                new Category(
                        "C1",
                        "Electronics");

        Product laptop =
                new Product(
                        "P1",
                        "MacBook",
                        120000,
                        electronics);

        Product mobile =
                new Product(
                        "P2",
                        "iPhone",
                        80000,
                        electronics);

        productService.addProduct(laptop);
        productService.addProduct(mobile);

        Warehouse warehouse =
                new Warehouse(
                        "W1",
                        "Kolkata Warehouse",
                        new Address(
                                "Kolkata",
                                "WB",
                                "700001"));

        warehouseService.addWarehouse(
                warehouse);

        User user =
                new User(
                        "U1",
                        "Wolf");

        userService.registerUser(user);

        cartService.addToCart(
                user,
                laptop,
                1);

        cartService.addToCart(
                user,
                mobile,
                2);

        // ── Observer Pattern: register notification channels ──────────────────
        orderService.addObserver(
                new EmailNotificationObserver("wolf@example.com"));

        orderService.addObserver(
                new SmsNotificationObserver("+91-9876543210"));

        orderService.addObserver(
                new PushNotificationObserver("DEVICE-TOKEN-ABC123"));
        // ─────────────────────────────────────────────────────────────────────

        System.out.println(
                "Cart Total : ₹"
                        + cartService
                        .getCartTotal(user));

        Order order =
                orderService.checkout(
                        "ORD-1",
                        user,
                        new Address(
                                "Delhi",
                                "Delhi",
                                "110001"),
                        new UpiPaymentStrategy(),
                        new NearestWarehouseStrategy());

        System.out.println();

        System.out.println(
                "Order Id : "
                        + order.getOrderId());

        System.out.println(
                "Warehouse : "
                        + order.getWarehouse()
                        .getWarehouseName());

        System.out.println(
                "Invoice : "
                        + order.getInvoice()
                        .getInvoiceId());

        System.out.println(
                "Payment Status : "
                        + order.getPayment()
                        .getStatus());

        System.out.println(
                "Order Status : "
                        + order.getStatus());

        System.out.println(
                "User Orders : "
                        + user.getOrders()
                        .size());
    }
}
