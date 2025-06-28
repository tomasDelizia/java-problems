package com.tomasdelizia.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void intersectTest() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersection = ArrayTransform.intersect(nums1, nums2);
        assertArrayEquals(new int[]{2, 2}, intersection);

        nums1 = new int[]{21,47,80,4,3,24,87,12,22,11,48,6,89,80,74,71,74,55,58,56,4,98,40,66,49,53,62,27,3,66,78,24,48,69,88,12,80,63,98,65,46,35,72,5,64,72,7,29,37,3,2,75,44,93,79,78,13,39,85,26,15,41,87,47,29,93,41,74,6,48,17,89,27,61,2,68,99,57,45,73,25,33,38,32,58};
        nums2 = new int[]{1,39,6,81,85,10,38,22,0,89,57,93,58,69,65,80,84,24,27,54,37,36,26,88,2,7,24,36,51,5,74,57,45,56,55,67,25,33,78,49,16,79,74,80,36,27,89,49,64,73,96,60,92,31,98,72,22,31,0,93,70,87,80,66,75,69,81,52,94,90,51,90,74,36,58,38,50,9,64,55,4,21,49,60,65,47,67,8,38,83};
        intersection = ArrayTransform.intersect(nums1, nums2);
        assertEquals(48, intersection.length);

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        intersection = ArrayTransform.intersect(nums1, nums2);
        assertArrayEquals(new int[]{4, 9}, intersection);

        nums1 = new int[]{1, 2, 3};
        nums2 = new int[]{4, 5, 6};
        intersection = ArrayTransform.intersect(nums1, nums2);
        assertArrayEquals(new int[]{}, intersection);

        nums1 = new int[]{1, 2, 2, 1};
        nums2 = new int[]{2, 2};
        intersection = ArrayTransform.intersect(nums1, nums2);
        assertArrayEquals(new int[]{2, 2}, intersection);
    }
}