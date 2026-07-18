package com.security.java_project.system_design.questions.fooddelivery.serviceImpl;

import com.security.java_project.system_design.questions.fooddelivery.entity.*;
import com.security.java_project.system_design.questions.fooddelivery.servics.DeliveryPartnerService;
import com.security.java_project.system_design.questions.fooddelivery.servics.RestaurantService;
import com.security.java_project.system_design.questions.fooddelivery.servics.CartService;
import com.security.java_project.system_design.questions.fooddelivery.servics.OrderService;
import com.security.java_project.system_design.questions.fooddelivery.strategy.CreditCardPayment;

import java.util.List;


public class FoodDeliveryServiceImpl {


    private final RestaurantService restaurantService;
    private final CartService cartService;
    private final OrderService orderService;
    private final PaymentService paymentService;
    private final DeliveryPartnerService deliveryPartnerService;

    public FoodDeliveryServiceImpl(
            RestaurantService restaurantService,
            CartService cartService,
            OrderService orderService,
            PaymentService paymentService,
            DeliveryPartnerService deliveryPartnerService) {

        this.restaurantService = restaurantService;
        this.cartService = cartService;
        this.orderService = orderService;
        this.paymentService = paymentService;
        this.deliveryPartnerService = deliveryPartnerService;
    }

        public List<Restaurant> searchRestaurant (String name){
            return restaurantService.searchRestaurant(name);
        }
        public Menu getMenu(long id)
        {
            return restaurantService.getMenu(id);
        }
        public void checkOut(User user,Cart cart)
        {
            System.out.println("Creating Order");
           Order order= orderService.createOrder(user, cart);
            System.out.println("Generating Bill");
            Bill bill=orderService.generateBill(order);
           paymentService.setPaymentStrategy(new CreditCardPayment("1234"));
            System.out.println("Making Payment");

            paymentService.makePayment(bill.getItemTotal());

            System.out.println("Placing Order");
            orderService.placeOrder(order);

            Restaurant restaurant = cart.getRestaurant();
            System.out.println("Restaurant Accept");
            restaurantService.acceptOrder(restaurant, order);

            restaurantService.startPreparing(order);
            restaurantService.markReady(order);
            System.out.println("Assign Partner");

            DeliveryPartner partner = deliveryPartnerService.assignPartner(order);
            System.out.println("Assigned Partner : " + partner.getName());

            deliveryPartnerService.pickUp(order);
            System.out.println("Deliver");
            deliveryPartnerService.deliver(order);
            cartService.clearCart(cart);
            System.out.println("Checkout Completed");

        }
}
