package com.tomasdelizia.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortStrategyTest {
    private final Sorter<Integer> sorter = new MergeSortStrategy<>();

    @Test
    void mergeSortWithEmptyArray() {
        Integer[] nums = {};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{}, nums);
    }

    @Test
    void mergeSortWithSingleElementArray() {
        Integer[] nums = {5};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{5}, nums);
    }

    @Test
    void mergeSortWithMultipleElements() {
        Integer[] nums = {5, 3, 8, 1, 2};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{1, 2, 3, 5, 8}, nums);

        nums = new Integer[]{10, -1, 0, 5};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{-1, 0, 5, 10}, nums);

        nums = new Integer[]{7, 7, 7};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{7, 7, 7}, nums);
    }

}