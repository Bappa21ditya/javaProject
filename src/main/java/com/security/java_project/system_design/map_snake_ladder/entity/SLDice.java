package com.security.java_project.system_design.map_snake_ladder.entity;

public class SLDice {
    private final int diceCount;

    private static final int MIN = 1;
    private static final int MAX = 6;

    public SLDice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int getDiceCount() {
        return diceCount;
    }

    public int getMin() {
        return MIN;
    }

    public int getMax() {
        return MAX;
    }
}
