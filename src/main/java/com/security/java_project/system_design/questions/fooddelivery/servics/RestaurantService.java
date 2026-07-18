package com.security.java_project.system_design.questions.fooddelivery.servics;

import com.security.java_project.system_design.questions.fooddelivery.entity.Menu;
import com.security.java_project.system_design.questions.fooddelivery.entity.Order;
import com.security.java_project.system_design.questions.fooddelivery.entity.Restaurant;

import java.util.List;

public interface RestaurantService {


    public List<Restaurant> searchRestaurant(String keyword);

    public Menu getMenu(long id);

  //  void acceptOrder(Order order);

    void startPreparing(Order order);

    void markReady(Order order);

    List<Order> getActiveOrders(Restaurant restaurant);

    void acceptOrder(Restaurant restaurant, Order order);

    void completeOrder(Restaurant restaurant, Order order);


}
