package com.tomasdelizia.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertionSortStrategyTest {
    private final ArraySorter<Integer> sorter = new InsertionSortStrategy<>();
    private final ArraySorter<Integer> sorterDesc = new InsertionSortStrategy<>((a, b) -> b - a);

    @Test
    void simpleInsertionSortWithEmptyArray() {
        Integer[] nums = {};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{}, nums);
    }

    @Test
    void simpleInsertionSortWithSingleElementArray() {
        Integer[] nums = {5};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{5}, nums);
    }

    @Test
    void simpleInsertionSortWithMultipleElements() {
        Integer[] nums = {5, 3, 8, 1, 2};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{1, 2, 3, 5, 8}, nums);

        nums = new Integer[]{10, -1, 0, 5};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{-1, 0, 5, 10}, nums);

        nums = new Integer[]{7, 7, 7};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{7, 7, 7}, nums);

        nums = new Integer[]{5, 3, 8, 1, 2};
        sorterDesc.sort(nums);
        assertArrayEquals(new Integer[]{8, 5, 3, 2, 1}, nums);

        nums = new Integer[]{10, -1, 0, 5};
        sorterDesc.sort(nums);
        assertArrayEquals(new Integer[]{10, 5, 0, -1}, nums);
    }

}