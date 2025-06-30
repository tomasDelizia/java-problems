package com.tomasdelizia.problem.backtracking;

import java.util.Arrays;

public class EightQueens {
    // Position of each queen in the board
    // c = column number where the queen is positioned
    // rowOnColumn[c] = row number where the queen is positioned
    private final int[] rowOnColumn = new int[8];

    // queensOnRow[i] = true if the row i is free of queens
    private final boolean[] queensOnRow = new boolean[8];

    // queensOnInverseDiagonal[id] = true if the inverse diagonal id is free of queens
    // where 0 <= id <= 14 identifies an unique inverse diagonal value that results of col j + row i
    // Two spots are on the same inverse diagonal if they have the same id value
    private final boolean[] queensOnInverseDiagonal = new boolean[15];

    // queensOnNormalDiagonal[id] = true if the normal diagonal nd is free of queens
    // where 0 <= nd <= 14 identifies an unique normal diagonal value that results of col j - row i + 7
    // Two spots are on the same normal diagonal if they have the same nd value
    private final boolean[] queensOnNormalDiagonal = new boolean[15];

    private int step;

    private int solutionCounter;

    public EightQueens() {
        step = 1;
        solutionCounter = 0;
        // Initially, no spot has a queen set in place
        Arrays.fill(rowOnColumn, -1);
        // Initially all values are true
        // Initialize queensOnRow, the inverse and normal diagonals to true (no queens placed)
        Arrays.fill(queensOnRow, true);
        Arrays.fill(queensOnInverseDiagonal, true);
        Arrays.fill(queensOnNormalDiagonal, true);
    }

    /**
     * Solves the Eight Queens problem by trying to place queens on an 8x8 chessboard
     * such that no two queens threaten each other.
     *
     * @return An array where the index represents the column and the value at that index
     * represents the row where a queen is placed.
     */
    public int[] solve() {
        // Tries to position the first queen on the fist column and
        // applies backtracking to calculate the other positions
        boolean success = intend(0);
        if (success) {
            System.out.println("Possible solution: " + Arrays.toString(rowOnColumn));
            printBoard();
        } else {
            System.out.println("No solution found for the starting position: " + Arrays.toString(rowOnColumn));
        }
        return rowOnColumn;
    }

    /**
     * Solves all possible configurations of the Eight Queens problem.
     *
     * @return The number of valid configurations found.
     */
    public int solveAll() {
        // Tries to position the first queen on the fist column and
        // applies backtracking to calculate the other positions
        return intendAll(0);
    }

    private void printBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (rowOnColumn[col] == row) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Attempts to place a queen in the specified column and recursively tries to place
     * queens in subsequent columns.
     *
     * @param column The current column where a queen is being placed.
     * @return true if all queens are placed successfully, false otherwise.
     */
    private boolean intend(int column) {
        //int row = -1;

        // If all queens are placed validly, return true
        boolean result = false;
        // Explore all rows in the current column if there is no result
        for (int row = 0; row < 8 && !result; row++) { //  or while (!result && row != 7) {
            // row++;

            // Try to place a queen in the current column and row
            int inverseDiagonal = column + row;
            int normalDiagonal = column - row + 7;
            boolean isRowFree = queensOnRow[row];
            boolean isInverseDiagonalFree = queensOnInverseDiagonal[inverseDiagonal];
            boolean isNormalDiagonalFree = queensOnNormalDiagonal[normalDiagonal];
            if (isRowFree && isInverseDiagonalFree && isNormalDiagonalFree) {
                // It's safe to place a queen at column and row
                System.out.println("Step " + step++ + ") Placing queen at column " + column + ", row " + row);
                rowOnColumn[column] = row;
                queensOnRow[row] = false;
                queensOnInverseDiagonal[inverseDiagonal] = false;
                queensOnNormalDiagonal[normalDiagonal] = false;
                if (column == 7) {
                    result = true;
                    break;
                }
                // Recursively try to place the next queen in the next column
                result = intend(column + 1);
                if (!result) {
                    System.out.println("Attempt failed. Backtracking from column " + column + ", row " + row);
                    queensOnRow[row] = true;
                    queensOnInverseDiagonal[inverseDiagonal] = true;
                    queensOnNormalDiagonal[normalDiagonal] = true;
                }
            }
        }
        return result;
    }

    private int intendAll(int column) {
        // Does not use result flag, but counts the number of solutions
        for (int row = 0; row < 8; row++) {
            int inverseDiagonal = column + row;
            int normalDiagonal = column - row + 7;
            boolean isRowFree = queensOnRow[row];
            boolean isInverseDiagonalFree = queensOnInverseDiagonal[inverseDiagonal];
            boolean isNormalDiagonalFree = queensOnNormalDiagonal[normalDiagonal];
            if (isRowFree && isInverseDiagonalFree && isNormalDiagonalFree) {
                rowOnColumn[column] = row;
                queensOnRow[row] = false;
                queensOnInverseDiagonal[inverseDiagonal] = false;
                queensOnNormalDiagonal[normalDiagonal] = false;
                if (column == 7) {
                    solutionCounter++;
                    System.out.println("Solution " + solutionCounter + ": " + Arrays.toString(rowOnColumn));
                    printBoard();
                } else {
                    intendAll(column + 1);
                }
                // Delete solution after finding it
                queensOnRow[row] = true;
                queensOnInverseDiagonal[inverseDiagonal] = true;
                queensOnNormalDiagonal[normalDiagonal] = true;
            }
        }
        return solutionCounter;
    }
}
