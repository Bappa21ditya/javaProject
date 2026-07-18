package com.security.java_project.system_design.parkingLot.entity;

import com.security.java_project.system_design.parkingLot.enums.ParkingSpotStatus;
import com.security.java_project.system_design.parkingLot.enums.ParkingSpotType;

public class ParkingSpot {
    private int id;
    private ParkingSpotType parkingSpotType;
    private ParkingSpotStatus parkingSpotStatus;
    private Vehicle vehicle;

    public ParkingSpot(int id,
                       ParkingSpotType parkingSpotType,
                       ParkingSpotStatus parkingSpotStatus) {
        this.id = id;
        this.parkingSpotType = parkingSpotType;
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
