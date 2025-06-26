package com.tomasdelizia.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArraySearcherTest {

    @Test
    void binarySearchWithEmptyArray() {
        int[] nums = {};
        int value = 5;
        int index = ArraySearcher.binarySearch(nums, value);
        assertEquals(-1, index);
    }

    @Test
    void binarySearchWithSingleElementArray() {
        int[] nums = {5};
        int value = 5;
        int index = ArraySearcher.binarySearch(nums, value);
        assertEquals(0, index);

        value = 3;
        index = ArraySearcher.binarySearch(nums, value);
        assertEquals(-1, index);
    }

    @Test
    void binarySearchWithMultipleElements() {
        int[] nums = {1, 3, 5, 7, 9};
        int value = 5;
        int index = ArraySearcher.binarySearch(nums, value);
        assertEquals(2, index);

        value = 1;
        index = ArraySearcher.binarySearch(nums, value);
        assertEquals(0, index);

        value = 9;
        index = ArraySearcher.binarySearch(nums, value);
        assertEquals(4, index);

        value = 6;
        index = ArraySearcher.binarySearch(nums, value);
        assertEquals(-1, index);
    }

}