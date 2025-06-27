package com.tomasdelizia.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayTransformTest {
    @Test
    void mergeSortedWithEmptyArrays() {
        int[] nums1 = {};
        int[] nums2 = {};
        int[] merged = ArrayTransform.mergeSorted(nums1, nums2);
        assertArrayEquals(new int[]{}, merged);
    }

    @Test
    void mergeSortedWithSingleElementArrays() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        int[] merged = ArrayTransform.mergeSorted(nums1, nums2);
        assertArrayEquals(new int[]{1, 2}, merged);

        nums1 = new int[]{3};
        nums2 = new int[]{2};
        merged = ArrayTransform.mergeSorted(nums1, nums2);
        assertArrayEquals(new int[]{2, 3}, merged);
    }

    @Test
    void mergeSortedWithMultipleElements() {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        int[] merged = ArrayTransform.mergeSorted(nums1, nums2);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, merged);

        nums1 = new int[]{5, 7, 9};
        nums2 = new int[]{1, 3, 8};
        merged = ArrayTransform.mergeSorted(nums1, nums2);
        assertArrayEquals(new int[]{1, 3, 5, 7, 8, 9}, merged);
    }

    @Test
    void removeDuplicatesWithEmptyArray() {
        int[] nums = {};
        int k = ArrayTransform.removeDuplicates(nums);
        assertArrayEquals(new int[]{}, nums);
        assert k == 0;
    }

    @Test
    void removeDuplicatesWithSingleElementArray() {
        int[] nums = {1};
        int k = ArrayTransform.removeDuplicates(nums);
        assertArrayEquals(new int[]{1}, nums);
        assert k == 1;
    }

    @Test
    void removeDuplicatesWithMultipleElements() {
        int[] nums = {1, 1, 2};
        int k = ArrayTransform.removeDuplicates(nums);
        assertArrayEquals(new int[]{1, 2, 2}, nums);
        assert k == 2;

        nums = new int[]{1, 1, 2, 3, 3, 4};
        k = ArrayTransform.removeDuplicates(nums);
        assertArrayEquals(new int[]{1, 2, 3, 4, 3, 4}, nums);
        assert k == 4;

        nums = new int[]{5, 5, 5, 5};
        k = ArrayTransform.removeDuplicates(nums);
        assertArrayEquals(new int[]{5, 5, 5, 5}, nums);
        assert k == 1;
    }

    @Test
    void rotateWithSingleElementArray() {
        int[] nums = {1};
        ArrayTransform.rotate(nums, 1);
        assertArrayEquals(new int[]{1}, nums);

        nums = new int[]{1, 2};
        ArrayTransform.rotate(nums, 3);
        assertArrayEquals(new int[]{2, 1}, nums);

        nums = new int[]{1, 2, 3};
        ArrayTransform.rotate(nums, 4);
        assertArrayEquals(new int[]{3, 1, 2}, nums);

        nums = new int[]{1, 2};
        ArrayTransform.rotate(nums, 5);
        assertArrayEquals(new int[]{2, 1}, nums);
    }

    @Test
    void rotateWithMultipleElements() {
        int[] nums = {1, 2, 3, 4, 5};
        ArrayTransform.rotate(nums, 2);
        assertArrayEquals(new int[]{4, 5, 1, 2, 3}, nums);

        nums = new int[]{1, 2, 3, 4, 5};
        ArrayTransform.rotate(nums, 5);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, nums);

        nums = new int[]{1, 2, 3};
        ArrayTransform.rotate(nums, 1);
        assertArrayEquals(new int[]{3, 1, 2}, nums);

        nums = new int[]{1, 2, 3, 4, 5};
        ArrayTransform.rotate(nums, 3);
        assertArrayEquals(new int[]{3, 4, 5, 1, 2}, nums);
    }
}