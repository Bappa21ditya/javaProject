package com.security.java_project.system_design.movieBooking.entity;

public class User {
    public int id;
    public String name, email,phone;
    public User(int id,String name,String email,String phone)
    {
        this.id=id;
        this.name=name;
        this.email=email;
        this.phone=phone;
    }
}
