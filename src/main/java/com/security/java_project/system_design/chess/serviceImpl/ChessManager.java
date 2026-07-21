package com.security.java_project.system_design.chess.serviceImpl;
import com.security.java_project.system_design.chess.entities.Cell;
import com.security.java_project.system_design.chess.entities.Game;
import com.security.java_project.system_design.chess.services.GameService;

public class ChessManager {private final GameService gameService;

    public ChessManager(GameService gameService) {
        this.gameService = gameService;
    }

    public Game startGame() {
        return gameService.startGame();
    }

    public void movePiece(Game game,
                          Cell source,
                          Cell destination) {

        gameService.movePiece(source,
                destination,
                game);
    }

    public void showBoard(Game game) {
        gameService.showBoard(game.getBoard());
    }

}
