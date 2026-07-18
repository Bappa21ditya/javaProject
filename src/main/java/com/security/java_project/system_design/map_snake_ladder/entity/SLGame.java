package com.security.java_project.system_design.map_snake_ladder.entity;

import java.util.List;

public class SLGame {
    private SLBoard slboard;

    private List<SLPlayer> players;

    public SLPlayer getWinner() {
        return winner;
    }

    public void setWinner(SLPlayer winner) {
        this.winner = winner;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public List<SLPlayer> getPlayers() {
        return players;
    }

    public SLDice getDice() {
        return dice;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public void setDice(SLDice dice) {
        this.dice = dice;
    }

    public void setSlboard(SLBoard slboard) {
        this.slboard = slboard;
    }

    public void setPlayers(List<SLPlayer> players) {
        this.players = players;
    }

    public SLBoard getSlboard() {
        return slboard;
    }

    private SLDice dice;

    private SLPlayer winner;

    private int currentPlayerIndex;

}
