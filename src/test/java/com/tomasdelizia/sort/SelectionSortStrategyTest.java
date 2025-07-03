package com.tomasdelizia.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortStrategyTest {
    private final Sorter<Integer> sorter = new SelectionSortStrategy<>();
    
    @Test
    void insertionSortWithEmptyArray() {
        Integer[] nums = {};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{}, nums);
    }

    @Test
    void insertionSortWithSingleElementArray() {
        Integer[] nums = {5};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{5}, nums);
    }

    @Test
    void insertionSortWithMultipleElements() {
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
