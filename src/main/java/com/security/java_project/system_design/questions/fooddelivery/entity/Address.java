package com.security.java_project.system_design.questions.fooddelivery.entity;

public class Address {

    String city;
    int Zipcode;
    String post;
    String dist;
    String state;

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getZipcode() {
        return Zipcode;
    }

    public void setZipcode(int zipcode) {
        Zipcode = zipcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address(String city) {
        this.city = city;
    }
}
