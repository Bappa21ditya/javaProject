package com.security.java_project.system_design.questions.fooddelivery.entity;

import java.util.ArrayList;
import java.util.List;

public class User{

    int id;
    String name;
    Address address;
    private String phone;
    private String email;
    private Cart cart;
    private List<Order> orders=new ArrayList<>();

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
//    public User(int id,String name,Address address,String email,String phone) {
//        this.id = id;
//        this.address=address;
//        this.name=name;
//        this.email=email;
//        this.phone=phone;
//    }
}
