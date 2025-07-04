package com.tomasdelizia.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortStrategyTest {
    private final Sorter<Integer> sorter = new QuickSortStrategy<>();

    @Test
    void quickSortWithEmptyArray() {
        Integer[] nums = {};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{}, nums);
    }

    @Test
    void quickSortWithSingleElementArray() {
        Integer[] nums = {5};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{5}, nums);
    }

    @Test
    void quickSortWithMultipleElements() {
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