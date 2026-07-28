package com.security.java_project.system_design.MyList.elevatorSystem.entity;

import com.security.java_project.system_design.MyList.elevatorSystem.enums.DoorStatus;

public class Door {

    DoorStatus doorStatus;

    public Door(DoorStatus doorStatus) {
        this.doorStatus = doorStatus;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public void setDoorStatus(DoorStatus doorStatus) {
        this.doorStatus = doorStatus;
    }
}
