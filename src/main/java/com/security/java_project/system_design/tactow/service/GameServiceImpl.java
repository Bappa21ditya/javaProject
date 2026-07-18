package com.security.java_project.system_design.tactow.service;

 import ch.qos.logback.core.encoder.EchoEncoder;
 import com.security.java_project.system_design.tactow.entities.Game;
 import com.security.java_project.system_design.tactow.entities.Player;

 import java.util.Scanner;



public class GameServiceImpl implements GameService {


    private final Game game;

    private final Scanner scanner = new Scanner(System.in);

    public GameServiceImpl(Game game) {
        this.game = game;
    }

    @Override
    public void startGame() {

        System.out.println("===== Game Started =====");

        while (game.getWinner() == null && !isBoardFull()) {
            playTurn();
        }

        System.out.println();

        if (game.getWinner() != null) {
            System.out.println("Winner : " + game.getWinner().getName());
        } else {
            System.out.println("Match Draw");
        }
    }

    void playTurn() {
        Player currentPlayer = findCurrentPlayer();

        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("Current Player : " + currentPlayer.getName());

        System.out.print("Enter row: ");
        int row = scanner.nextInt();

        System.out.print("Enter column: ");
        int col = scanner.nextInt();

        if (!validateMove(row, col)) {
            System.out.println("Invalid move. Try again.");
            return;
        }

        char symbol = currentPlayer.getSymbol();

        game.getBoard().placeSymbol(row, col, symbol);

        printBoard();

        if (checkWinner(row, col, symbol)) {
            game.setWinner(currentPlayer);
            return;
        }

        nextTurn();

        }

    private Player findCurrentPlayer() {
        return game.getPlayerList()
                .get(game.getCurrentPlayerIndex());
    }

    private boolean isBoardFull() {
        for (int i = 0; i < game.getBoard().getSize(); i++) {
            for (int j = 0; j < game.getBoard().getSize(); j++) {
                if (game.getBoard().getSymbol(i, j) == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

private boolean validateMove(int row, int col) {

    int size = game.getBoard().getSize();

    if (row < 0 || row >= size) {
        return false;
    }

    if (col < 0 || col >= size) {
        return false;
    }

    if (game.getBoard().getSymbol(row, col) != '\0') {
        return false;
    }

    return true;
}

    private void printBoard() {

        for (int i = 0; i < game.getBoard().getSize(); i++) {

            for (int j = 0; j < game.getBoard().getSize(); j++) {

                char ch = game.getBoard().getSymbol(i, j);

                if (ch == '\0') {
                    ch = '-';
                }

                System.out.print(ch + " ");

            }

            System.out.println();

        }
    }

    private  boolean  checkWinner(int row, int col, char symbol) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for (int i = 0; i < game.getBoard().getSize(); i++) {

            if (game.getBoard().getSymbol(row, i) == '\0' || game.getBoard().getSymbol(row, i) != symbol) {
                rowMatch = false;
                break;
            }
        }
        for (int i = 0; i < game.getBoard().getSize(); i++) {

            if( game.getBoard().getSymbol(i,col)=='\0' || game.getBoard().getSymbol(i,col)!=symbol)
            {
                columnMatch=false;
                break;
            }
        }

        for (int i = 0; i < game.getBoard().getSize(); i++) {

            if( game.getBoard().getSymbol(i,i)=='\0' || game.getBoard().getSymbol(i,i)!=symbol)
            {
                diagonalMatch=false;
                break;
            }
        }

        for (int i = 0; i < game.getBoard().getSize(); i++) {

            if (game.getBoard().getSymbol(i,
                    game.getBoard().getSize() - 1 - i) != symbol) {

                antiDiagonalMatch = false;
                break;
            }

        }
        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
    private void nextTurn() {

        int nextIndex =
                (game.getCurrentPlayerIndex() + 1)
                        % game.getPlayerList().size();

        game.setCurrentPlayerIndex(nextIndex);

    }
}


