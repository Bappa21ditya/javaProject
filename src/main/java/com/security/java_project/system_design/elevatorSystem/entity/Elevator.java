package com.security.java_project.system_design.elevatorSystem.entity;

import com.security.java_project.system_design.elevatorSystem.enums.Direction;
import com.security.java_project.system_design.elevatorSystem.enums.DoorStatus;
import com.security.java_project.system_design.elevatorSystem.enums.ElevatorStatus;

public class Elevator {

    int id;

    Door door;

    ElevatorStatus elevatorStatus;

    int currentFloor;

    Direction direction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public ElevatorStatus getElevatorStatus() {
        return elevatorStatus;
    }

    public void setElevatorStatus(ElevatorStatus elevatorStatus) {
        this.elevatorStatus = elevatorStatus;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void openDoor() {
        door.setDoorStatus(DoorStatus.DOOR_OPEN);
    }

    public void closeDoor() {
        door.setDoorStatus(DoorStatus.DOOR_CLOSED);
    }


    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Elevator(int id, Direction direction, int currentFloor, Door door, ElevatorStatus elevatorStatus) {
        this.id = id;
        this.direction = direction;
        this.currentFloor = currentFloor;
        this.door = door;
        this.elevatorStatus = elevatorStatus;
    }


}
