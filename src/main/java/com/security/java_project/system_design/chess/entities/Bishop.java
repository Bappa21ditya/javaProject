package com.security.java_project.system_design.chess.entities;

import com.security.java_project.system_design.chess.enums.PieceColor;
import com.security.java_project.system_design.chess.enums.PieceType;

public class Bishop extends Piece{
    public Bishop() {
    }

    public Bishop(PieceType pieceType, PieceColor pieceColor) {
        super(pieceType, pieceColor);
    }

    @Override
    public boolean validateMove(Board board, Cell source, Cell destination) {

        int rowDiff = Math.abs(destination.getRow() - source.getRow());
        int colDiff = Math.abs(destination.getCol() - source.getCol());

        // Same Cell
        if (rowDiff == 0 && colDiff == 0) {
            return false;
        }

        // Diagonal Move
        if (rowDiff == colDiff) {
            return true;
        }

        return false;
    }
}
