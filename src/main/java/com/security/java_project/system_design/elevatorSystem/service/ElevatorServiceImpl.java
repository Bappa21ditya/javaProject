package com.security.java_project.system_design.elevatorSystem.service;

import com.security.java_project.system_design.elevatorSystem.entity.Building;
import com.security.java_project.system_design.elevatorSystem.entity.Elevator;
import com.security.java_project.system_design.elevatorSystem.enums.Direction;
import com.security.java_project.system_design.elevatorSystem.enums.ElevatorStatus;
import com.security.java_project.system_design.elevatorSystem.strategy.ElevatorSelectionStrategy;


public class ElevatorServiceImpl implements ElevatorService {

    private final Building building;

    private final ElevatorSelectionStrategy strategy;

    public ElevatorServiceImpl(Building building,
                               ElevatorSelectionStrategy strategy) {
        this.building = building;
        this.strategy = strategy;
    }


    @Override
    public Elevator callElevator(int floor, Direction direction) {
        Elevator elevator =
                strategy.findBestElevator(
                        building.getElevators(),
                        floor
                        , direction);

        updateDirection(elevator, direction);

        moveElevator(floor, elevator);

        openDoor(elevator);

        System.out.println("Passenger enter");
        return elevator;
    }

    @Override
    public void selectFloor(Elevator elevator, int destinationFloor) {

        closeDoor(elevator);
        moveElevator(destinationFloor, elevator);
        openDoor(elevator);
        System.out.println("passenger exit");
        closeDoor(elevator);
        elevator.setElevatorStatus(ElevatorStatus.IDLE);


    }


    private void updateDirection(Elevator elevator, Direction direction) {
        elevator.setDirection(direction);
        System.out.println(elevator.getCurrentFloor());
    }

    private void moveElevator(int floor, Elevator elevator) {

        int currentFloor = elevator.getCurrentFloor();

        if (floor > currentFloor) {

            elevator.setElevatorStatus(ElevatorStatus.MOVING_UP);

            while (currentFloor < floor) {

                currentFloor++;

                elevator.setCurrentFloor(currentFloor);

                System.out.println("Passing Floor : " + currentFloor);
            }

        } else if (floor < currentFloor) {

            elevator.setElevatorStatus(ElevatorStatus.MOVING_DOWN);

            while (currentFloor > floor) {

                currentFloor--;

                elevator.setCurrentFloor(currentFloor);

                System.out.println("Passing Floor : " + currentFloor);
            }

        } else {

            System.out.println("Elevator already on floor " + floor);
        }

        elevator.setElevatorStatus(ElevatorStatus.IDLE);

        System.out.println(
                "Elevator "
                        + elevator.getId()
                        + " reached floor "
                        + elevator.getCurrentFloor());
    }

    private void openDoor(Elevator elevator) {
        elevator.openDoor();
    }

    private void closeDoor(Elevator elevator) {
        elevator.closeDoor();

    }


}
