package com.security.java_project.system_design.parkingLot.entity;
import com.security.java_project.system_design.parkingLot.enums.VehicleType;

public class Vehicle {
    private int id;
    private String vehicleNumber;
    private VehicleType vehicleType;

    public Vehicle(int id, String vehicleNumber, VehicleType vehicleType) {
        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
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

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
