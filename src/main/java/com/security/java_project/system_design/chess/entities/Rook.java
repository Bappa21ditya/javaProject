package com.security.java_project.system_design.chess.entities;

import com.security.java_project.system_design.chess.enums.PieceColor;
import com.security.java_project.system_design.chess.enums.PieceType;

public class Rook extends Piece{
    public Rook(PieceType pieceType, PieceColor pieceColor) {
        super(pieceType, pieceColor);
    }

    public Rook() {

    }

    @Override
    public boolean validateMove(Board board, Cell source, Cell destination) {
        int rowDiff = Math.abs(destination.getRow() - source.getRow());
        int colDiff = Math.abs(destination.getCol() - source.getCol());

        // Same Cell
        if (rowDiff == 0 && colDiff == 0) {
            return false;
        }

        // Horizontal Move
        if (source.getRow() == destination.getRow()) {
            return true;
        }

        // Vertical Move
        if (source.getCol() == destination.getCol()) {
            return true;
        }

        return false;
    }
}
