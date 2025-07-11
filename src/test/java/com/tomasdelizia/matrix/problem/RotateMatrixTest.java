package com.tomasdelizia.matrix.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RotateMatrixTest {
    @Test
    void testRotateSquareMatrix() {
        int[][] input = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        int[][] expected = new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3},
        };
        RotateMatrix.rotateSquareMatrix(input);
        for (int i = 0; i < input.length; i++) {
            assertArrayEquals(expected[i], input[i]);
        }
    }
}