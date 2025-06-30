package com.tomasdelizia.problem.backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EightQueensTest {

    @Test
    void eightQueens() {
        EightQueens eightQueens = new EightQueens();
        // Test the eight queens problem
        int[] expected = {0, 4, 7, 5, 2, 6, 1, 3};
        assertArrayEquals(expected, eightQueens.solve());
    }

    @Test
    void eightQueensAllSolutions() {
        EightQueens eightQueens = new EightQueens();
        // Test all possible solutions for the eight queens problem
        int solutions = eightQueens.solveAll();
        // There are 92 valid configurations for the Eight Queens problem
        assertEquals(92, solutions);
    }
}