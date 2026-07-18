package com.security.java_project.system_design.map_snake_ladder.entity;



import java.util.Map;

public class SLBoard {
    int size;

    Map<Integer, SLJump>jumps;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setJumps(Map<Integer, SLJump> jumps) {
        this.jumps = jumps;
    }

    public SLJump getJump(int position) {
        return jumps.get(position);
    }
}
