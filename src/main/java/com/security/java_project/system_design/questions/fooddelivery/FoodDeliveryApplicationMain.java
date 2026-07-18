package com.security.java_project.system_design.questions.fooddelivery;

import com.security.java_project.system_design.questions.fooddelivery.entity.*;
import com.security.java_project.system_design.questions.fooddelivery.serviceImpl.*;
import com.security.java_project.system_design.questions.fooddelivery.servics.DeliveryPartnerService;
import com.security.java_project.system_design.questions.fooddelivery.servics.OrderService;
import com.security.java_project.system_design.questions.fooddelivery.servics.RestaurantService;
import com.security.java_project.system_design.questions.fooddelivery.servics.CartService;
import com.security.java_project.system_design.questions.fooddelivery.strategy.PaymentStrategy;


import java.util.ArrayList;
import java.util.List;

public class FoodDeliveryApplicationMain {
    public static void main(String[] args) {

        // ==========================
        // Create Menu Items
        // ==========================
        MenuItem pizza = new MenuItem(1, "Margherita Pizza",
                "Cheese Pizza", 299.0, true);

        MenuItem burger = new MenuItem(2, "Veg Burger",
                "Loaded Veg Burger", 149.0, true);

        MenuItem coke = new MenuItem(3, "Coke",
                "Cold Drink", 50.0, true);

        // ==========================
        // Create Menu
        // ==========================
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(pizza);
        menuItems.add(burger);
        menuItems.add(coke);

        Menu menu = new Menu();
        menu.setId(1);
        menu.setName("Main Menu");
        menu.setMenuItems(menuItems);

        // ==========================
        // Create Restaurant
        // ==========================
        Restaurant restaurant = new Restaurant();
        restaurant.setId(1);
        restaurant.setName("Dominos");
        restaurant.setMenu(menu);

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(restaurant);

        // ==========================
        // Create Delivery Partners
        // ==========================
        DeliveryPartner partner1 = new DeliveryPartner();
        partner1.setId(1);
        partner1.setName("Rahul");
        partner1.setAvailable(true);

        DeliveryPartner partner2 = new DeliveryPartner();
        partner2.setId(2);
        partner2.setName("Amit");
        partner2.setAvailable(true);

        List<DeliveryPartner> partners = new ArrayList<>();
        partners.add(partner1);
        partners.add(partner2);

        // ==========================
        // Create User & Cart
        // this.id = id;
        //        this.address=address;
        //        this.name=name;
        //        this.email=email;
        //        this.phone=phone;
        // ==========================
        User user = new User();
        user.setId(1);
        user.setName("Falcon");

        Cart cart = new Cart();
        cart.setId(1);
        cart.setUser(user);
        cart.setRestaurant(restaurant);
        cart.setCartItems(new ArrayList<>());

        user.setCart(cart);

        // ==========================
        // Create Services
        // ==========================
        RestaurantService restaurantService =
                new RestaurantServiceImpl(restaurants);

        CartService cartService =
                new CartServiceImpl();

        OrderService orderService =
                new OrderServiceImpl();

        PaymentService paymentService =
                new PaymentService();

        DeliveryPartnerService deliveryPartnerService =
                new FoodDeliveryPartnerServiceImpl(partners);

        FoodDeliveryServiceImpl foodDeliveryService =
                new FoodDeliveryServiceImpl(
                        restaurantService,
                        cartService,
                        orderService,
                        paymentService,
                        deliveryPartnerService);

        // ==========================
        // Search Restaurant
        // ==========================
        List<Restaurant> result =
                foodDeliveryService.searchRestaurant("Pizza");

        System.out.println("Restaurants Found:");

        for (Restaurant r : result) {
            System.out.println(r.getName());
        }

        // ==========================
        // View Menu
        // ==========================
        Menu restaurantMenu =
                foodDeliveryService.getMenu(restaurant.getId());

        System.out.println("\nMenu:");

        for (MenuItem item : restaurantMenu.getMenuItems()) {
            System.out.println(item.getName() + " ₹" + item.getPrice());
        }

        // ==========================
        // Add Items to Cart
        // ==========================
        cartService.addItem(cart, pizza, 2);
        cartService.addItem(cart, coke, 1);

        // ==========================
        // View Cart
        // ==========================
        cartService.viewCart(cart);

        // ==========================
        // Checkout
        // ==========================
        foodDeliveryService.checkOut(user, cart);
    }
}
