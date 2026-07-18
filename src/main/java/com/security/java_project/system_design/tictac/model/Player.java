package com.security.java_project.system_design.tictac.model;

public class Player {
    public String name;
    public PlayingPiece playingPiece;

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(String name,PlayingPiece playingPiece) {
        this.name=name;
        this.playingPiece=playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }

    public String getName() {
        return name;
    }
}
