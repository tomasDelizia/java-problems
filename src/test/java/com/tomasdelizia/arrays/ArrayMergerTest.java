package com.tomasdelizia.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayMergerTest {
    @Test
    void mergeSortedWithEmptyArrays() {
        int[] nums1 = {};
        int[] nums2 = {};
        int[] merged = ArrayMerger.mergeSorted(nums1, nums2);
        assertArrayEquals(new int[]{}, merged);
    }

    @Test
    void mergeSortedWithSingleElementArrays() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        int[] merged = ArrayMerger.mergeSorted(nums1, nums2);
        assertArrayEquals(new int[]{1, 2}, merged);

        nums1 = new int[]{3};
        nums2 = new int[]{2};
        merged = ArrayMerger.mergeSorted(nums1, nums2);
        assertArrayEquals(new int[]{2, 3}, merged);
    }

    @Test
    void mergeSortedWithMultipleElements() {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        int[] merged = ArrayMerger.mergeSorted(nums1, nums2);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, merged);

        nums1 = new int[]{5, 7, 9};
        nums2 = new int[]{1, 3, 8};
        merged = ArrayMerger.mergeSorted(nums1, nums2);
        assertArrayEquals(new int[]{1, 3, 5, 7, 8, 9}, merged);
    }

}