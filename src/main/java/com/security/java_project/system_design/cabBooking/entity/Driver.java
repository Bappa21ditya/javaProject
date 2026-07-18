package com.security.java_project.system_design.cabBooking.entity;

public class Driver {

    private int id;

    private String name;

    private Location location;

    private Vehicle vehicle;

    public Driver() {
    }

    public Driver(int id,
                  String name,
                  Location location,
                  Vehicle vehicle) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }



    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
