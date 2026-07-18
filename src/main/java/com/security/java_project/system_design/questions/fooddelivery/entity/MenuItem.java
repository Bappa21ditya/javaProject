package com.security.java_project.system_design.questions.fooddelivery.entity;

public class MenuItem {
    private int id;

    private String name;

    private String description;

    private double price;

    private boolean available;


    public MenuItem(int id,String name,String description,Double price,boolean available) {
        this.id = id;
        this.name=name;
        this.description=description;
        this.price=price;
        this.available=available;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
