package com.security.java_project.system_design.parkingLot.entity;

import java.util.List;

public class Floor {

    private int id;
    private List<ParkingSpot> parkingSpotList;

    public Floor(int id, List<ParkingSpot> parkingSpotList) {
        this.id = id;
        this.parkingSpotList = parkingSpotList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }
}
