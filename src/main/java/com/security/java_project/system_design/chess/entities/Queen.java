package com.security.java_project.system_design.chess.entities;

import com.security.java_project.system_design.chess.enums.PieceColor;
import com.security.java_project.system_design.chess.enums.PieceType;

public class Queen extends Piece{

    public Queen() {
    }

    public Queen(PieceType pieceType, PieceColor pieceColor) {
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

        // Horizontal Move
        if (source.getRow() == destination.getRow()) {
            return isHorizontalPathClear(board,
                    source,
                    destination);
        }

        // Vertical Move
        if (source.getCol() == destination.getCol()) {
            return isVerticalPathClear(board,
                    source,
                    destination);
        }

        if(destination.getPiece() != null &&
                destination.getPiece().getPieceColor()
                        == this.getPieceColor()){
            return  false;

        }

        return false;
    }

    private boolean isHorizontalPathClear(Board board,
                                          Cell source,
                                          Cell destination) {

        int row = source.getRow();

        int start =
                Math.min(source.getCol(),
                        destination.getCol()) + 1;

        int end =
                Math.max(source.getCol(),
                        destination.getCol());

        for (int col = start; col < end; col++) {

            if (board.getCell(row, col).getPiece() != null) {
                return false;
            }

        }

        return true;
    }

    private boolean isVerticalPathClear(Board board,
                                        Cell source,
                                        Cell destination) {

        int col = source.getCol();

        int start =
                Math.min(source.getRow(),
                        destination.getRow()) + 1;

        int end =
                Math.max(source.getRow(),
                        destination.getRow());

        for (int row = start; row < end; row++) {

            if (board.getCell(row, col).getPiece() != null) {
                return false;
            }

        }

        return true;
    }

}

