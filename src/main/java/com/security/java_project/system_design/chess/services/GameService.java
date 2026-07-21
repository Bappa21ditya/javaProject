package com.security.java_project.system_design.chess.services;

import com.security.java_project.system_design.chess.entities.Board;
import com.security.java_project.system_design.chess.entities.Cell;
import com.security.java_project.system_design.chess.entities.Game;

public interface GameService {
    Game startGame();

    void movePiece(Cell source,
                   Cell destination,
                   Game game);

    void changeTurn(Game game);

    void showBoard(Board board);
}
