package com.security.java_project.system_design.questions.fooddelivery.entity;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private long id;

    private String name;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    private Address address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Menu menu;

    private List<Order> orders;

    private List<Order> activeOrders = new ArrayList<>();

    public List<Order> getActiveOrders() {
        return activeOrders;
    }

    public void setActiveOrders(List<Order> activeOrders) {
        this.activeOrders = activeOrders;
    }
}
