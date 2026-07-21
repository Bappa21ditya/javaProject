package com.security.java_project.system_design.chess.entities;

public class Board {

    private Cell[][] cells;

    public Board() {
    }

    public Board(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }
}
