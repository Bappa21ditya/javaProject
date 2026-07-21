package com.security.java_project.system_design.chess.entities;

import com.security.java_project.system_design.chess.enums.PieceColor;
import com.security.java_project.system_design.chess.enums.PieceType;

public class  King extends Piece {
    public King() {
    }

    public King(PieceType pieceType, PieceColor pieceColor) {
        super(pieceType, pieceColor);
    }

    @Override
    public boolean validateMove(Board board,
                                Cell source,
                                Cell destination) {

        int rowDiff = Math.abs(destination.getRow() - source.getRow());
        int colDiff = Math.abs(destination.getCol() - source.getCol());

        // Same Cell
        if (rowDiff == 0 && colDiff == 0) {
            return false;
        }

            if (rowDiff > 1 && colDiff > 1) {
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

            // Diagonal Move
            if (rowDiff == colDiff) {
                return true;
            }

            return false;
        }

}
