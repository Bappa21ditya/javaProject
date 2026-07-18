package com.security.java_project.system_design.questions.fooddelivery.serviceImpl;

import com.security.java_project.system_design.questions.fooddelivery.entity.Menu;
import com.security.java_project.system_design.questions.fooddelivery.entity.MenuItem;
import com.security.java_project.system_design.questions.fooddelivery.entity.Order;
import com.security.java_project.system_design.questions.fooddelivery.entity.Restaurant;
import com.security.java_project.system_design.questions.fooddelivery.enums.OrderStatus;
import com.security.java_project.system_design.questions.fooddelivery.servics.RestaurantService;

import java.util.ArrayList;
import java.util.List;

public class RestaurantServiceImpl implements RestaurantService {

    private final List<Restaurant> restaurants;

    public RestaurantServiceImpl(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public List<Restaurant> searchRestaurant(String keyword) {
        List<Restaurant> result = new ArrayList<>();

        // Step 1: Search by restaurant name
        for (Restaurant restaurant : restaurants) {

            if (restaurant.getName()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {

                result.add(restaurant);
            }
        }

        // If restaurant(s) found, return immediately
        if (!result.isEmpty()) {
            return result;
        }

        // Step 2: Search by food name
        for (Restaurant restaurant : restaurants) {

            for (MenuItem item : restaurant.getMenu().getMenuItems()) {

                if (item.getName()
                        .toLowerCase()
                        .contains(keyword.toLowerCase())) {

                    result.add(restaurant);
                    break; // Avoid duplicate restaurants
                }
            }
        }

        return result;
    }

    @Override
    public Menu getMenu(long id) {

        for (Restaurant restaurant : restaurants) {
                if (restaurant.getId() == id) {
                    return restaurant.getMenu();
                }
            }

        return null;

    }


    @Override
    public void acceptOrder(Restaurant restaurant, Order order) {

        restaurant.getActiveOrders().add(order);

        order.setStatus(OrderStatus.CONFIRMED);
    }

    @Override
    public void startPreparing(Order order) {
        order.setStatus(OrderStatus.PREPARING);

    }

    @Override
    public void markReady(Order order) {
        order.setStatus(OrderStatus.READY);
    }


    @Override
    public List<Order> getActiveOrders(Restaurant restaurant) {

        return restaurant.getActiveOrders();
    }
    @Override
    public void completeOrder(Restaurant restaurant, Order order) {

        restaurant.getActiveOrders().remove(order);

        order.setStatus(OrderStatus.COMPLETED);
    }
}

