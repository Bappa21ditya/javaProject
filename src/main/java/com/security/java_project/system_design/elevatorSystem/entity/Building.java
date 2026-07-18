package com.security.java_project.system_design.elevatorSystem.entity;

import java.util.List;

public class Building {
    int id;
    List<Floor> floors;
    List<Elevator> elevators;

    public List<Elevator> getElevators() {
        return elevators;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public Building(int id,List<Floor> floors,List<Elevator> elevators) {
        this.id = id;
        this.elevators=elevators;
        this.floors=floors;
    }
}
