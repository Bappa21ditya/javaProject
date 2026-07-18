package com.security.java_project.system_design.questions.fooddelivery.entity;

import java.util.ArrayList;
import java.util.List;

public class DeliveryPartner {
    private long id;

    private String name;

    public List<Order> getAssignedOrders() {
        return assignedOrders;
    }

    public void setAssignedOrders(List<Order> assignedOrders) {
        this.assignedOrders = assignedOrders;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String phone;

    private boolean available;

    private List<Order> assignedOrders=new ArrayList<>();
}
