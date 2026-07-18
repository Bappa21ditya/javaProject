package com.security.java_project.system_design.inventory.entity;

public class Address {
    private String city;
    private String state;
    private String pinCode;
    public Address(String city,
                   String state,
                   String pinCode) {
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPinCode() {
        return pinCode;
    }

    @Override
    public String toString() {
        return city + ", " + state + " - " + pinCode;
    }

}
