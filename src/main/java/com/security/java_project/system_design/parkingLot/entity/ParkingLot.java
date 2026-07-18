package com.security.java_project.system_design.parkingLot.entity;

import java.util.List;

public class ParkingLot {
    private int id;
    private List<Floor> floorList;

    public ParkingLot(int id, List<Floor> floorList) {
        this.id = id;
        this.floorList = floorList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }
}
