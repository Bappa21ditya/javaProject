package com.security.java_project.system_design.map_snake_ladder.service;

import com.security.java_project.system_design.map_snake_ladder.entity.SLGame;
import com.security.java_project.system_design.map_snake_ladder.entity.SLJump;
import com.security.java_project.system_design.map_snake_ladder.entity.SLPlayer;

public class SLGameServiceImpl implements SLGameService{

//    private SLGame game;
//    private SLDiceService diceService;
//
//    public SLGameServiceImpl(SLGame game,SLDiceService slDiceService) {
//        this.game = game;
//        this.diceService=slDiceService;
//    }
//
//    @Override
//    public void startGame() {
//        while (game.getWinner() == null) {
//
//            playTurn();
//
//        }
//
//        System.out.println(
//                "Winner is : "
//                        + game.getWinner().getName()
//        );
//    }

    private final SLGame game;

    private final SLDiceService diceService;

    public SLGameServiceImpl(SLGame game,
                             SLDiceService diceService) {

        this.game = game;
        this.diceService = diceService;
    }

    @Override
    public void startGame() {

        System.out.println("===== Game Started =====");

        while (game.getWinner() == null) {

            playTurn();

        }

        System.out.println();
        System.out.println("===========================");
        System.out.println("Winner : " + game.getWinner().getName());
        System.out.println("===========================");
    }
    private void playTurn() {

        SLPlayer currentPlayer = findCurrentPlayer();

        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("Current Player : " + currentPlayer.getName());
        System.out.println("Current Position : " + currentPlayer.getCurrentPosition());

        int diceValue = diceService.rollDice();

        System.out.println("Dice : " + diceValue);

        movePlayer(currentPlayer, diceValue);

        checkWinner(currentPlayer);

        nextTurn();
    }
    private SLPlayer findCurrentPlayer() {
       return game.getPlayers().get(game.getCurrentPlayerIndex());
    }

    private void movePlayer(SLPlayer player,
                            int diceValue) {

        int currentPosition = player.getCurrentPosition();

        int newPosition = currentPosition + diceValue;

        if (newPosition > game.getSlboard().getSize()) {

            System.out.println("Move ignored. Beyond board.");

            return;
        }

        newPosition = applyJump(newPosition);

        player.setCurrentPosition(newPosition);

        System.out.println(
                player.getName()
                        + " moved to "
                        + newPosition
        );
    }
    private int applyJump(int position) {

        SLJump jump =
                game.getSlboard().getJump(position);

        if (jump == null) {

            return position;
        }

        if (jump.getStart() < jump.getEnd()) {

            System.out.println("Ladder Found!");

        } else {

            System.out.println("Snake Bite!");

        }

        return jump.getEnd();
    }
    private void checkWinner(SLPlayer player) {

        if (player.getCurrentPosition()
                == game.getSlboard().getSize()) {

            game.setWinner(player);

        }

    }
    private void nextTurn() {

        int nextIndex =
                (game.getCurrentPlayerIndex() + 1)
                        % game.getPlayers().size();

        game.setCurrentPlayerIndex(nextIndex);

    }


}
