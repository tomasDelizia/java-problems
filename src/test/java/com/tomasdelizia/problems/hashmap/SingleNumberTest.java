package com.tomasdelizia.problems.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleNumberTest {
    @Test
    void testSingleNumber() {
        int[] nums1 = {2, 2, 1};
        assertEquals(1, SingleNumber.singleNumber(nums1));

        int[] nums2 = {4, 1, 2, 1, 2};
        assertEquals(4, SingleNumber.singleNumber(nums2));

        int[] nums3 = {1};
        assertEquals(1, SingleNumber.singleNumber(nums3));

        int[] nums4 = {0, 1, 0};
        assertEquals(1, SingleNumber.singleNumber(nums4));
    }

    @Test
    void testSingleNumberXor() {
        int[] nums1 = {2, 2, 1};
        assertEquals(1, SingleNumber.singleNumberXor(nums1));

        int[] nums2 = {4, 1, 2, 1, 2};
        assertEquals(4, SingleNumber.singleNumberXor(nums2));

        int[] nums3 = {1};
        assertEquals(1, SingleNumber.singleNumberXor(nums3));

        int[] nums4 = {0, 1, 0};
        assertEquals(1, SingleNumber.singleNumberXor(nums4));
    }

}