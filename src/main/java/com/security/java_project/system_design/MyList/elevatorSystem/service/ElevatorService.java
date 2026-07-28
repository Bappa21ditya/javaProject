package com.security.java_project.system_design.MyList.elevatorSystem.service;

import com.security.java_project.system_design.MyList.elevatorSystem.entity.Elevator;
import com.security.java_project.system_design.MyList.elevatorSystem.enums.Direction;

public interface ElevatorService {

    Elevator callElevator(int floor, Direction direction);

    void selectFloor(Elevator elevator, int destinationFloor);

}
