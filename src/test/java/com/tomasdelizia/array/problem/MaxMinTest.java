package com.tomasdelizia.array.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxMinTest {
    @Test
    void testMaxMin() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int[] expected = {9, 1};
        int[] result = MaxMin.maxMin(arr);
        assertArrayEquals(expected, result);
    }

}