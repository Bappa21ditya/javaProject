package com.security.java_project.system_design.chess.entities;

import com.security.java_project.system_design.chess.enums.PieceColor;

public class Player {

    private int id;
    private String name;
    private PieceColor pieceColor;

    public Player() {
    }

    public Player(int id,
                  String name,
                  PieceColor pieceColor) {
        this.id = id;
        this.name = name;
        this.pieceColor = pieceColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }
}
