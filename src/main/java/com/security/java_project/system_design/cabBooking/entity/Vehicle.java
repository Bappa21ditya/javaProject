package com.security.java_project.system_design.cabBooking.entity;

import com.security.java_project.system_design.cabBooking.enums.RideType;

public class Vehicle {

    private int id;

    private String vehicleNumber;

    private RideType rideType;

    public Vehicle() {
    }

    public Vehicle(int id,
                   String vehicleNumber,
                   RideType rideType) {
        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.rideType = rideType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }



    public RideType getRideType() {
        return rideType;
    }

    public void setRideType(RideType rideType) {
        this.rideType = rideType;
    }
}
