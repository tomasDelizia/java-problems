package com.tomasdelizia.backtracking;

import java.util.*;

public class ValidSudoku {
    /**
     * Checks if a given 9x9 Sudoku board is valid.
     * @param board the 9x9 Sudoku board represented as a 2D character array
     * @return true if the board is valid, false otherwise
     */
    public static boolean isValidSudoku(char[][] board) {
        int n = board.length, m = board[0].length;
        if (n != 9 || m != 9) return false;

        Map<Integer, Set<Character>> seenInRow = new HashMap<>();
        Map<Integer, Set<Character>> seenInCol = new HashMap<>();
        Map<Box, Set<Character>> seenInBox = new HashMap<>();

        // Initialize the maps for rows, columns, and boxes
        for (int i = 0; i < 9; i++) {
            seenInRow.put(i, new HashSet<>());
            seenInCol.put(i, new HashSet<>());
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                seenInBox.put(new Box(i, j), new HashSet<>());
            }
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char current = board[r][c];
                if (current == '.') continue;
                Box box = new Box(r/3, c/3);
                if (seenInRow.get(r).contains(current) ||
                        seenInCol.get(c).contains(current) ||
                        seenInBox.get(box).contains(current)
                ) return false;
                seenInRow.get(r).add(current);
                seenInCol.get(c).add(current);
                seenInBox.get(box).add(current);
            }
        }
        return true;
    }

    record Box(int x, int y) {}
}
