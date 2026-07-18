package com.security.java_project.system_design.elevatorSystem;

import com.security.java_project.system_design.elevatorSystem.entity.Building;
import com.security.java_project.system_design.elevatorSystem.entity.Door;
import com.security.java_project.system_design.elevatorSystem.entity.Elevator;
import com.security.java_project.system_design.elevatorSystem.entity.Floor;
import com.security.java_project.system_design.elevatorSystem.enums.Direction;
import com.security.java_project.system_design.elevatorSystem.enums.DoorStatus;
import com.security.java_project.system_design.elevatorSystem.enums.ElevatorStatus;
import com.security.java_project.system_design.elevatorSystem.service.ElevatorOrchestrator;
import com.security.java_project.system_design.elevatorSystem.service.ElevatorService;
import com.security.java_project.system_design.elevatorSystem.service.ElevatorServiceImpl;
import com.security.java_project.system_design.elevatorSystem.strategy.ElevatorSelectionStrategy;
import com.security.java_project.system_design.elevatorSystem.strategy.NearestElevatorStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorsApplicationsMain {

  public static   void main(String args[]) {

        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        Floor floor3 = new Floor(3);
        Floor floor4 = new Floor(4);
        Floor floor5 = new Floor(5);
        Floor floor6 = new Floor(6);

        Door door1=new Door(DoorStatus.DOOR_CLOSED);
        Door door2=new Door(DoorStatus.DOOR_CLOSED);
        Door door3=new Door(DoorStatus.DOOR_CLOSED);

        Elevator elevator1 = new Elevator(1, Direction.UP, 2,  door1, ElevatorStatus.IDLE);
        Elevator elevator2 = new Elevator(2, Direction.DOWN, 5,door2, ElevatorStatus.IDLE);
        Elevator elevator3 = new Elevator(3, Direction.UP, 3, door3, ElevatorStatus.MOVING_DOWN);

        List<Floor> floorList = new ArrayList<>();
        floorList.add(floor1);
        floorList.add(floor2);
        floorList.add(floor3);
        floorList.add(floor4);
        floorList.add(floor5);
        floorList.add(floor6);

        List<Elevator> elevatorList = new ArrayList<>();
        elevatorList.add(elevator1);
        elevatorList.add(elevator2);
        elevatorList.add(elevator3);

        Building building = new Building(1, floorList, elevatorList);
        ElevatorSelectionStrategy strategy = new NearestElevatorStrategy();

        ElevatorService elevatorService =
                new ElevatorServiceImpl(building, strategy);

        ElevatorOrchestrator controller =
                new ElevatorOrchestrator(elevatorService);

        Elevator elevator =
                controller.callElevator(2, Direction.UP);

        controller.selectFloor(elevator, 4);

    }
}
