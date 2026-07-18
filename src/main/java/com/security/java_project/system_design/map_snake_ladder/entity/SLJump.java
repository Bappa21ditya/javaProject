package com.security.java_project.system_design.map_snake_ladder.entity;

public class SLJump {
    int start;
    int end;

    public SLJump(int start,int end) {
        this.start = start;
        this.end=end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getEnd() {
        return end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStart() {
        return start;
    }
}
