package com.security.java_project.system_design.hotelBooking.entity;

public class User {
    private int id;

    public int getId() {
        return id;
    }

    public User(int id,String name,String address) {
        this.id = id;
        this.address=address;
        this.name=name;
    }

    private String name;
    private String address;
}
