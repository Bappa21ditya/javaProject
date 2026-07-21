package com.security.java_project.system_design.chess;
import com.security.java_project.system_design.chess.entities.*;
import com.security.java_project.system_design.chess.enums.PieceColor;
import com.security.java_project.system_design.chess.enums.PieceType;
import com.security.java_project.system_design.chess.serviceImpl.ChessManager;
import com.security.java_project.system_design.chess.serviceImpl.GameServiceImpl;
import com.security.java_project.system_design.chess.services.GameService;


public class ChessApplicationMain {
    public static void main(String args[])
    {



//        GameService gameService =
//                new GameServiceImpl();
//
//        ChessManager manager =
//                new ChessManager(gameService);
//
//        Game game =
//                manager.startGame();
//
//// test moves
//        Cell sourceCell =
//                game.getBoard()
//                        .getCell(0,3);
//
//        Cell destinationCell =
//                game.getBoard()
//                        .getCell(2,3);
//
//
//        manager.movePiece(game,
//                sourceCell,
//                destinationCell);
//
//        manager.showBoard(game);
        GameService gameService = new GameServiceImpl();

        ChessManager manager = new ChessManager(gameService);

        Game game = manager.startGame();

        // -----------------------------
        // Clear the board
        // -----------------------------
        Cell[][] cells = game.getBoard().getCells();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                cells[row][col].setPiece(null);
            }
        }

        // -----------------------------
        // Place only one Queen
        // -----------------------------
        cells[3][3].setPiece(
                new Queen(
                        PieceType.QUEEN,
                        PieceColor.WHITE));

        System.out.println("\nBoard Before Move");
        manager.showBoard(game);

        // -----------------------------
        // Move Queen
        // -----------------------------
        Cell sourceCell =
                game.getBoard().getCell(3, 3);

        Cell destinationCell =
                game.getBoard().getCell(3, 6);

        manager.movePiece(
                game,
                sourceCell,
                destinationCell);

        System.out.println("\nBoard After Move");
        manager.showBoard(game);
    }

}
