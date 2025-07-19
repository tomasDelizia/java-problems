package com.tomasdelizia.hash.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentElementsTest {

    @Test
    void testTopKFrequent() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] expected = {2, 1};
        int[] result = TopKFrequentElements.topKFrequent(nums, k);
        assertArrayEquals(expected, result);

        nums = new int[]{1};
        k = 1;
        expected = new int[]{1};
        result = TopKFrequentElements.topKFrequent(nums, k);
        assertArrayEquals(expected, result);

        nums = new int[]{-1, -1, -2, -2, -3};
        k = 2;
        expected = new int[]{-1, -2};
        result = TopKFrequentElements.topKFrequent(nums, k);
        assertArrayEquals(expected, result);
    }
}