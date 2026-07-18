package com.security.java_project.system_design.elevatorSystem.strategy;

import com.security.java_project.system_design.elevatorSystem.entity.Elevator;
import com.security.java_project.system_design.elevatorSystem.enums.Direction;

import java.util.List;

import static java.lang.Math.abs;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy {
    @Override
    public Elevator findBestElevator(List<Elevator> elevators, int requestedFloor, Direction direction) {
        int bestDistance = Integer.MAX_VALUE;
        Elevator bestElevator = null;

        for (Elevator elevator : elevators) {
            int distance =
                    abs(elevator.getCurrentFloor() - requestedFloor);

            if (distance < bestDistance) {
                bestDistance = distance;
                bestElevator = elevator;
            }
        }

        return bestElevator;
    }
}
