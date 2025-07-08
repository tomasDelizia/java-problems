package com.tomasdelizia.hash.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubArraySumTest {
    @Test
    void testSubArraySum() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int value1 = 9;
        int[] expected1 = {1, 3}; // Subarray [1, 2, 3, 4] sums to 9
        assertArrayEquals(expected1, SubArraySum.subarraySum(nums1, value1));

        int[] nums2 = {5, -3, 2, 7};
        int value2 = 4;
        int[] expected2 = {0, 2}; // No subarray sums to 4
        assertArrayEquals(expected2, SubArraySum.subarraySum(nums2, value2));

        int[] nums3 = {10, -10, 20};
        int value3 = 20;
        int[] expected3 = {2, 2}; // Subarray [2, 2] sums to 20
        assertArrayEquals(expected3, SubArraySum.subarraySum(nums3, value3));

        int[] nums4 = {1};
        int value4 = 1;
        int[] expected4 = {0, 0}; // Single element subarray
        assertArrayEquals(expected4, SubArraySum.subarraySum(nums4, value4));

        int[] nums5 = {};
        int value5 = 0;
        int[] expected5 = {}; // Empty array
        assertArrayEquals(expected5, SubArraySum.subarraySum(nums5, value5));
    }

}