package com.security.java_project.system_design.MyList.tactow;

import com.security.java_project.system_design.MyList.tactow.entities.Board;
import com.security.java_project.system_design.MyList.tactow.entities.Game;
import com.security.java_project.system_design.MyList.tactow.entities.Player;
import com.security.java_project.system_design.MyList.tactow.service.GameService;
import com.security.java_project.system_design.MyList.tactow.service.GameServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class tictowApplicationMain {
    public static void main(String[] args) {
        Player player1 = new Player("jhon", 'X');
        Player player2 = new Player("jack", '0');
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);


        Board board=new Board(3);
        Game game=new Game();
        game.setPlayerList(players);
        game.setBoard(board);
        game.setCurrentPlayerIndex(0);

        GameService gameService= new GameServiceImpl(game);
        gameService.startGame();



    }

}
