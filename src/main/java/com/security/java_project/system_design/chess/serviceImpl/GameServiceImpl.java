package com.security.java_project.system_design.chess.serviceImpl;

import com.security.java_project.system_design.chess.entities.*;
import com.security.java_project.system_design.chess.enums.GameStatus;
import com.security.java_project.system_design.chess.enums.PieceColor;
import com.security.java_project.system_design.chess.enums.PieceType;
import com.security.java_project.system_design.chess.services.GameService;

public class GameServiceImpl implements GameService {
    @Override
    public Game  startGame() {

        Game game=new Game();

        // 1. Create Board
        Cell[][] grid = new Cell[8][8];

        for (int row = 0; row < 8; row++) {

            for (int col = 0; col < 8; col++) {

                grid[row][col] =
                        new Cell(row,
                                col, null);

            }

        }

        Board board = new Board(grid);



        // 3. Place White Pieces
        initializePieces(board);

        // 4. Place Black Pieces

        // 5. Create Players

        Player player1=new Player();
        player1.setId(1);

        Player player2=new Player();
        player2.setId(2);

        player1.setName("White Wlker");
        player2.setName("Jhon Snow");

        player1.setPieceColor(PieceColor.WHITE);
        player2.setPieceColor(PieceColor.BLACK);



        // 6. Set Current Player = White

        game.setBoard(board);
        game.setWhitePlayer(player1);
        game.setBlackPlayer(player2);
        game.setCurrentPlayer(player1);
        // 7. Set GameStatus = IN_PROGRESS
        game.setGameStatus(GameStatus.IN_PROGRESS);


        // 8. Print Board

        showBoard(game.getBoard());

        return  game;

    }

    @Override
    public void movePiece(Cell source, Cell destination, Game game) {

        Piece piece = source.getPiece();

        if (piece == null) {
            System.out.println("No Piece Found");
            return;
        }

        if (!piece.validateMove(game.getBoard(),
                source,
                destination)) {

            System.out.println("Invalid Move");
            return;
        }

        capturePiece(destination);

        destination.setPiece(piece);

        source.setPiece(null);

        changeTurn(game);

        checkWinner(game);

        changeTurn(game);

        System.out.println(
                piece.getPieceType()
                        + " moved successfully");
    }

    @Override
    public void changeTurn(Game game) {

        if (game.getCurrentPlayer()
                == game.getWhitePlayer()) {

            game.setCurrentPlayer(
                    game.getBlackPlayer());

        } else {

            game.setCurrentPlayer(
                    game.getWhitePlayer());

        }

    }

    @Override
    public void showBoard(Board board) {

        Cell[][] cells = board.getCells();

        for (int i = 0; i < cells.length; i++) {

            for (int j = 0; j < cells[i].length; j++) {

                Piece piece = cells[i][j].getPiece();

                if (piece == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(
                            piece.getPieceType()
                                    .name()
                                    .charAt(0)
                                    + " ");
                }

            }

            System.out.println();

        }

    }
    private void capturePiece(Cell destination) {

        if (destination.getPiece() != null) {

            System.out.println(
                    destination.getPiece().getPieceType()
                            + " Captured");

        }

    }

    private void initializePieces(Board board) {

        for (int col = 0; col < 8; col++) {
            board.getCell(0, col).setPiece(createMajorPiece(col, PieceColor.BLACK));
            board.getCell(1, col).setPiece(new Pawn(PieceType.PAWN,PieceColor.BLACK));

            board.getCell(6, col).setPiece(new Pawn(PieceType.PAWN,PieceColor.WHITE));
            board.getCell(7, col).setPiece(createMajorPiece(col, PieceColor.WHITE));
        }
    }


    private Piece createMajorPiece(int col, PieceColor color) {
        switch (col) {
            case 0: case 7: return new Rook(PieceType.ROOK,color);
            case 1: case 6: return new Knight(PieceType.KNIGHT,color);
            case 2: case 5: return new Bishop(PieceType.BISHOP,color);
            case 3:          return new Queen(PieceType.QUEEN,color);
            case 4:          return new King(PieceType.KING,color);
            default:         return null;
        }
    }
    private  boolean checkWinner( Game game)
    {
        // implement later
        return false;
    }
    private void clearBoard(Board board) {

        Cell[][] cells = board.getCells();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                cells[row][col].setPiece(null);
            }
        }
    }
}
