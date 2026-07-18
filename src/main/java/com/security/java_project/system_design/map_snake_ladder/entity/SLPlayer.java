package com.security.java_project.system_design.map_snake_ladder.entity;

public class SLPlayer {
    String id;
    String name;
    int currentPosition;

    public SLPlayer(String id,String name, int currentPosition) {
        this.id = id;
        this.name=name;
        this.currentPosition = currentPosition;
    }

    public String getName() {
        return name;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
