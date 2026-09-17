package com.security.java_project.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nqueen {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        int[] colQueen = new int[n];

        solve(n, 0, colQueen);

        return result;
    }

    void solve(int n, int row, int[] colQueen) {

        // BASE CASE
        if (row == n) {

            result.add(createBoard(n, colQueen));

            return;
        }

        // Try every column in this row
        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, colQueen)) {

                // CHOOSE
                colQueen[row] = col;

                // EXPLORE
                solve(n, row + 1, colQueen);
            }
        }
    }

    boolean isSafe(int row, int col, int[] colQueen) {

        // Check all previously filled rows
        for (int r = 0; r < row; r++) {

            // Same column
            if (colQueen[r] == col) {
                return false;
            }

            // Same diagonal
            if (Math.abs(row - r) == Math.abs(col - colQueen[r])) {
                return false;
            }
        }

        return true;
    }

    List<String> createBoard(int n, int[] queenColumn) {

        List<String> board = new ArrayList<>();

        for (int row = 0; row < n; row++) {

            char[] currentRow = new char[n];

            Arrays.fill(currentRow, '.');

            currentRow[queenColumn[row]] = 'Q';

            board.add(new String(currentRow));
        }

        return board;
    }

    // MAIN METHOD FOR INTELLIJ
    public static void main(String[] args) {

        Nqueen nqueen = new Nqueen();

        int n = 4;

        List<List<String>> answers = nqueen.solveNQueens(n);

        for (List<String> board : answers) {

            for (String row : board) {
                System.out.println(row);
            }

            System.out.println();
        }
    }
}
