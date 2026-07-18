package com.security.java_project.system_design.map_snake_ladder;

import com.security.java_project.system_design.map_snake_ladder.entity.*;
import com.security.java_project.system_design.map_snake_ladder.service.SLDiceService;
import com.security.java_project.system_design.map_snake_ladder.service.SLDiceServiceImpl;
import com.security.java_project.system_design.map_snake_ladder.service.SLGameService;
import com.security.java_project.system_design.map_snake_ladder.service.SLGameServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeAndLadderApplication {

    public static void main(String[] args) {

        /*
         * --------------------------------------
         * Create Board
         * --------------------------------------
         */
        SLBoard board = new SLBoard();
        board.setSize(100);

        Map<Integer, SLJump> jumps = new HashMap<>();

        // Ladders
        jumps.put(4, new SLJump(4, 25));
        jumps.put(13, new SLJump(13, 46));
        jumps.put(33, new SLJump(33, 49));
        jumps.put(42, new SLJump(42, 63));
        jumps.put(50, new SLJump(50, 69));

        // Snakes
        jumps.put(40, new SLJump(40, 3));
        jumps.put(54, new SLJump(54, 31));
        jumps.put(66, new SLJump(66, 45));
        jumps.put(76, new SLJump(76, 58));
        jumps.put(99, new SLJump(99, 41));

        board.setJumps(jumps);

        /*
         * --------------------------------------
         * Create Dice
         * --------------------------------------
         */
        SLDice dice = new SLDice(1);

        /*
         * --------------------------------------
         * Create Players
         * --------------------------------------
         */
        List<SLPlayer> players = new ArrayList<>();

        players.add(new SLPlayer("1", "Rahul", 0));
        players.add(new SLPlayer("2", "Amit", 0));
        players.add(new SLPlayer("3", "Priya", 0));

        /*
         * --------------------------------------
         * Create Game
         * --------------------------------------
         */
        SLGame game = new SLGame();

        game.setSlboard(board);
        game.setDice(dice);
        game.setPlayers(players);
        game.setCurrentPlayerIndex(0);

        /*
         * --------------------------------------
         * Create Services
         * --------------------------------------
         */
        SLDiceService diceService =
                new SLDiceServiceImpl(dice);

        SLGameService gameService =
                new SLGameServiceImpl(game, diceService);

        /*
         * --------------------------------------
         * Start Game
         * --------------------------------------
         */
        gameService.startGame();

    }

}
