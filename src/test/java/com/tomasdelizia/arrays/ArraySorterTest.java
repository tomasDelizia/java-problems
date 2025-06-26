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

    @Test
    void simpleInsertionSortWithEmptyArray() {
        int[] nums = {};
        ArraySorter.insertionSort(nums, 1);
        assertArrayEquals(new int[]{}, nums);
    }

    @Test
    void simpleInsertionSortWithSingleElementArray() {
        int[] nums = {5};
        ArraySorter.insertionSort(nums, 1);
        assertArrayEquals(new int[]{5}, nums);
    }

    @Test
    void simpleInsertionSortWithMultipleElements() {
        int[] nums = {5, 3, 8, 1, 2};
        ArraySorter.insertionSort(nums, 1);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, nums);

        nums = new int[]{10, -1, 0, 5};
        ArraySorter.insertionSort(nums, 1);
        assertArrayEquals(new int[]{-1, 0, 5, 10}, nums);

        nums = new int[]{7, 7, 7};
        ArraySorter.insertionSort(nums, 1);
        assertArrayEquals(new int[]{7, 7, 7}, nums);
    }

    @Test
    void shellSortWithEmptyArray() {
        int[] nums = {};
        ArraySorter.shellSort(nums);
        assertArrayEquals(new int[]{}, nums);
    }

    @Test
    void shellSortWithSingleElementArray() {
        int[] nums = {5};
        ArraySorter.shellSort(nums);
        assertArrayEquals(new int[]{5}, nums);
    }

    @Test
    void shellSortWithMultipleElements() {
        int[] nums = {5, 3, 8, 1, 2};
        ArraySorter.shellSort(nums);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, nums);

        nums = new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 9, 7, 2, 3, 8, 4, 6, 2, 6};
        ArraySorter.shellSort(nums);
        assertArrayEquals(new int[]{1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6, 7, 8, 9, 9}, nums);
    }

    @Test
    void heapSortWithEmptyArray() {
        int[] nums = {};
        ArraySorter.heapSort(nums);
        assertArrayEquals(new int[]{}, nums);
    }

    @Test
    void heapSortWithSingleElementArray() {
        int[] nums = {5};
        ArraySorter.heapSort(nums);
        assertArrayEquals(new int[]{5}, nums);
    }

    @Test
    void heapSortWithMultipleElements() {
        int[] nums = {3, 7, 5, 8};
        ArraySorter.heapSort(nums);
        assertArrayEquals(new int[]{3, 5, 7, 8}, nums);

        nums = new int[]{10, -1, 0, 5};
        ArraySorter.heapSort(nums);
        assertArrayEquals(new int[]{-1, 0, 5, 10}, nums);

        nums = new int[]{7, 7, 7};
        ArraySorter.heapSort(nums);
        assertArrayEquals(new int[]{7, 7, 7}, nums);
    }

    @Test
    void quickSortWithEmptyArray() {
        int[] nums = {};
        ArraySorter.quickSort(nums);
        assertArrayEquals(new int[]{}, nums);
    }

    @Test
    void quickSortWithSingleElementArray() {
        int[] nums = {5};
        ArraySorter.quickSort(nums);
        assertArrayEquals(new int[]{5}, nums);
    }

    @Test
    void quickSortWithMultipleElements() {
        int[] nums = {5, 8, 3, 7, 6, 9, 2};
        ArraySorter.quickSort(nums);
        assertArrayEquals(new int[]{2, 3, 5, 6, 7, 8, 9}, nums);

        nums = new int[]{10, -1, 0, 5};
        ArraySorter.quickSort(nums);
        assertArrayEquals(new int[]{-1, 0, 5, 10}, nums);

        nums = new int[]{7, 7, 7};
        ArraySorter.quickSort(nums);
        assertArrayEquals(new int[]{7, 7, 7}, nums);
    }
}