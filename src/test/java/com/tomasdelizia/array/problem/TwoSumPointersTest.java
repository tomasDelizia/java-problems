package com.tomasdelizia.array.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumPointersTest {
    @Test
    void testTwoSumWithPointersOnSorted() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        assertArrayEquals(expected, TwoSumPointers.twoSumWithPointersOnSorted(nums, target));

        nums = new int[]{2, 3, 4};
        target = 6;
        expected = new int[]{0, 2};
        assertArrayEquals(expected, TwoSumPointers.twoSumWithPointersOnSorted(nums, target));
    }
}