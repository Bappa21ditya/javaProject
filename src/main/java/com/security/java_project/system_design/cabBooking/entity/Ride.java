package com.security.java_project.system_design.cabBooking.entity;

import com.security.java_project.system_design.cabBooking.enums.RideStatus;

public class Ride {

    private int id;

    private User user;

    private Driver driver;

    private Vehicle vehicle;

    private Payment payment;

    private Route route;

    private RideStatus rideStatus;

    public Ride() {
    }

    public Ride(int id,
                User user,
                Driver driver,
                Vehicle vehicle,
                Payment payment,
                Route route,
                RideStatus rideStatus) {

        this.id = id;
        this.user = user;
        this.driver = driver;
        this.vehicle = vehicle;
        this.payment = payment;
        this.route = route;
        this.rideStatus = rideStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }



    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }



    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }



    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }



    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }
}
