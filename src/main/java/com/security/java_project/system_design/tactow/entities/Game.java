package com.security.java_project.system_design.tactow.entities;

import java.util.List;

public class Game {
    List<Player> playerList;
    Board board;
    private Player winner;
    private int currentPlayerIndex;

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }
}
