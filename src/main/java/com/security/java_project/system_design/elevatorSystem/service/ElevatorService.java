package com.security.java_project.system_design.elevatorSystem.service;

import com.security.java_project.system_design.elevatorSystem.entity.Elevator;
import com.security.java_project.system_design.elevatorSystem.enums.Direction;

public interface ElevatorService {

    Elevator callElevator(int floor, Direction direction);

    void selectFloor(Elevator elevator, int destinationFloor);

}
