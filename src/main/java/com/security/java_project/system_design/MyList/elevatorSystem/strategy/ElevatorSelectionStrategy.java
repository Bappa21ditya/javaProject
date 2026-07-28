package com.security.java_project.system_design.MyList.elevatorSystem.strategy;

import com.security.java_project.system_design.MyList.elevatorSystem.entity.Elevator;
import com.security.java_project.system_design.MyList.elevatorSystem.enums.Direction;

import java.util.List;

public interface ElevatorSelectionStrategy {
    Elevator findBestElevator(List<Elevator> elevators, int requestedFloor, Direction direction);
}
