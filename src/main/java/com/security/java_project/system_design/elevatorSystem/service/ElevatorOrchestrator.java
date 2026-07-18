package com.security.java_project.system_design.elevatorSystem.service;

import com.security.java_project.system_design.elevatorSystem.entity.Elevator;
import com.security.java_project.system_design.elevatorSystem.enums.Direction;


public class ElevatorOrchestrator {

    private final ElevatorService elevatorService;

    public ElevatorOrchestrator(ElevatorService elevatorService) {
        this.elevatorService = elevatorService;
    }

    public Elevator callElevator(int floor, Direction direction) {

        return elevatorService.callElevator(floor, direction);
    }

    public void selectFloor(Elevator elevator, int destinationFloor) {

        elevatorService.selectFloor(elevator, destinationFloor);
    }

}



