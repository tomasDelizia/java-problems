package com.tomasdelizia.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareMatrixUtilsTest {

    @Test
    void countZeroesInMainDiagonal() {
        int[][] mat1 = {
                {0, 1, 2},
                {3, 0, 4},
                {5, 6, 0}
        };
        assertEquals(3, SquareMatrixUtils.countZeroesInMainDiagonal(mat1));

        int[][] mat2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertEquals(0, SquareMatrixUtils.countZeroesInMainDiagonal(mat2));

        int[][] mat3 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        assertEquals(3, SquareMatrixUtils.countZeroesInMainDiagonal(mat3));
    }

    @Test
    void sumUpperTriangle() {
        int[][] mat1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertEquals(11, SquareMatrixUtils.sumUpperTriangle(mat1));

        int[][] mat2 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        assertEquals(0, SquareMatrixUtils.sumUpperTriangle(mat2));

        int[][] mat3 = {
                {1, 2},
                {3, 4}
        };
        assertEquals(2, SquareMatrixUtils.sumUpperTriangle(mat3));
    }

    @Test
    void sumInLowerTriangle() {
        int[][] mat1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertEquals(19, SquareMatrixUtils.sumInLowerTriangle(mat1));

        int[][] mat2 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        assertEquals(0, SquareMatrixUtils.sumInLowerTriangle(mat2));

        int[][] mat3 = {
                {1, 2},
                {3, 4}
        };
        assertEquals(3, SquareMatrixUtils.sumInLowerTriangle(mat3));
    }
}