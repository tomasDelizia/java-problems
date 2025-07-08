package com.tomasdelizia.array.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubarrayTest {
    @Test
    void maxSubarray() {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expectedSum1 = 6; // Subarray [4, -1, 2, 1] has the maximum sum
        assertEquals(expectedSum1, MaxSubarray.maxSubarray(nums1));

        int[] nums2 = {-2, -3, -1};
        int expectedSum2 = -1; // The maximum subarray is the single element -1
        assertEquals(expectedSum2, MaxSubarray.maxSubarray(nums2));

        int[] nums3 = {5, 4, -1, 7, 8};
        int expectedSum3 = 23; // The entire array is the maximum subarray
        assertEquals(expectedSum3, MaxSubarray.maxSubarray(nums3));

        int[] nums4 = {};
        int expectedSum4 = 0; // No elements in the array
        assertEquals(expectedSum4, MaxSubarray.maxSubarray(nums4));
    }

}