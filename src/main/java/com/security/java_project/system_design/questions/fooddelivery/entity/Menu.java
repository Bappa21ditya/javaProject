package com.security.java_project.system_design.questions.fooddelivery.entity;

import java.util.List;
import java.util.Map;

public class Menu{

    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    private String name;

    private Restaurant restaurant;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private List<MenuItem> menuItems;

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
