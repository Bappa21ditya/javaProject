package com.security.java_project.system_design.tactow.entities;

public class Player {
    String name;
    char Symbol;

    public String getName() {
        return name;
    }

    public Player(String name,char symbol) {
        this.name = name;
        this.Symbol=symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }

    public char getSymbol() {
        return Symbol;
    }
}
