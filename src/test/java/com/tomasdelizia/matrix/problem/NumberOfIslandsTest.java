package com.tomasdelizia.matrix.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfIslandsTest {
    @Test
    void testNumberOfIslands() {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int numIslands = NumberOfIslands.numIslands(grid);
        assertEquals(1, numIslands);

        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        numIslands = NumberOfIslands.numIslands(grid);
        assertEquals(3, numIslands);
    }
}