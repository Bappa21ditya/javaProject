package com.security.java_project.system_design.tactow.entities;

public class Board {
    int size;
    char [][]board;

    public Board(int size) {
        this.size = size;
        this.board = new char[size][size];

        // Optional: Fill with default value (e.g., space or '*')
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '\0';
            }
        }
    }

    public int getSize() {
        return size;
    }

    public char[][] getBoard() {
        return board;
    }

    public char getSymbol(int row,int col)
    {
        return board[row][col];
    }

   public void placeSymbol(int row,int col, char symbol)
   {
       board[row][col]=symbol;
   }

}
