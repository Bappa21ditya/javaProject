package com.security.java_project.system_design.tictac;

import com.security.java_project.system_design.tictac.model.GameStatus;

public class Playgame {

     public static void main(String[] args) {
            System.out.println("\n===>>> TicTacToe Game\n");
            TicTacToeGame game = new TicTacToeGame();
            game.initializeGame();
            GameStatus status = game.startGame();
            System.out.print("\n===>>> GAME OVER: ");
            switch (status) {
                case WIN:
                    System.out.print(game.winner.name + " won the game");
                    break;
                case DRAW:
                    System.out.print(" Its a Draw!");
                    break;
                default:
                    System.out.print(" Game Ends");
                    break;
            }

        }
}
