package com.security.java_project.system_design.map_snake_ladder.service;

import com.security.java_project.system_design.map_snake_ladder.entity.SLDice;

import java.util.concurrent.ThreadLocalRandom;

public class SLDiceServiceImpl implements SLDiceService{

private final SLDice dice;

    public SLDiceServiceImpl(SLDice dice) {
        this.dice = dice;
    }

    @Override
    public int rollDice() {

        int total = 0;

        for (int i = 0; i < dice.getDiceCount(); i++) {

            total += ThreadLocalRandom.current()
                    .nextInt(dice.getMin(), dice.getMax() + 1);

        }

        return total;


    }

}
