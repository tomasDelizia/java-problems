package com.tomasdelizia.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArraySorterTest {
    @Test
    void bubbleSortWithEmptyArray() {
        int[] nums = {};
        ArraySorter.bubbleSort(nums);
        assertArrayEquals(new int[]{}, nums);
    }

    @Test
    void bubbleSortWithSingleElementArray() {
        int[] nums = {5};
        ArraySorter.bubbleSort(nums);
        assertArrayEquals(new int[]{5}, nums);
    }

    @Test
    void bubbleSortWithMultipleElements() {
        int[] nums = {5, 3, 8, 1, 2};
        ArraySorter.bubbleSort(nums);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, nums);

        nums = new int[]{10, -1, 0, 5};
        ArraySorter.bubbleSort(nums);
        assertArrayEquals(new int[]{-1, 0, 5, 10}, nums);

        nums = new int[]{7, 7, 7};
        ArraySorter.bubbleSort(nums);
        assertArrayEquals(new int[]{7, 7, 7}, nums);
    }

}