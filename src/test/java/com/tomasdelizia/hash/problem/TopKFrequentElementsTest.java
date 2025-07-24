package com.tomasdelizia.hash.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentElementsTest {

    @Test
    void testTopKFrequentMinHeap() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] expected = {2, 1};
        int[] result = TopKFrequentElements.topKFrequentMinHeap(nums, k);
        assertArrayEquals(expected, result);

        nums = new int[]{1};
        k = 1;
        expected = new int[]{1};
        result = TopKFrequentElements.topKFrequentMinHeap(nums, k);
        assertArrayEquals(expected, result);

        nums = new int[]{-1, -1, -2, -2, -3};
        k = 2;
        expected = new int[]{-1, -2};
        result = TopKFrequentElements.topKFrequentMinHeap(nums, k);
        assertArrayEquals(expected, result);

        nums = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 100};
        k = 3;
        expected = new int[]{2, 3, 1};
        result = TopKFrequentElements.topKFrequentMinHeap(nums, k);
        assertArrayEquals(expected, result);
    }

    @Test
    void testTopKFrequentBucketSort() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] expected = {1, 2};
        int[] result = TopKFrequentElements.topKFrequentBucketSort(nums, k);
        assertArrayEquals(expected, result);

        nums = new int[]{1};
        k = 1;
        expected = new int[]{1};
        result = TopKFrequentElements.topKFrequentBucketSort(nums, k);
        assertArrayEquals(expected, result);

        nums = new int[]{-1, -1, -2, -2, -3};
        k = 2;
        expected = new int[]{-1, -2};
        result = TopKFrequentElements.topKFrequentBucketSort(nums, k);
        assertArrayEquals(expected, result);

        nums = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 100};
        k = 3;
        expected = new int[]{1, 3, 2};
        result = TopKFrequentElements.topKFrequentBucketSort(nums, k);
        assertArrayEquals(expected, result);
    }
}