package com.security.java_project.system_design.chess.entities;

import com.security.java_project.system_design.chess.enums.PieceColor;
import com.security.java_project.system_design.chess.enums.PieceType;

public abstract class Piece {
    private PieceType pieceType;
    private PieceColor pieceColor;

    public Piece() {
    }

    public Piece(PieceType pieceType,
                 PieceColor pieceColor) {

        this.pieceType=pieceType;
        this.pieceColor = pieceColor;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public abstract boolean validateMove(
            Board board,
            Cell source,
            Cell destination);
}
