package com.tomasdelizia.problem.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValuesInCommonTest {
    @Test
    void testValuesInCommon() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7, 8, 9, 10};
        assertFalse(ValuesInCommon.valuesInCommon(nums1, nums2));

        int[] nums3 = {1, 2, 3, 4, 5};
        int[] nums4 = {5, 6, 7, 8, 9};
        assertTrue(ValuesInCommon.valuesInCommon(nums3, nums4));

        int[] nums5 = {1};
        int[] nums6 = {1};
        assertTrue(ValuesInCommon.valuesInCommon(nums5, nums6));

        int[] nums7 = {};
        int[] nums8 = {1};
        assertFalse(ValuesInCommon.valuesInCommon(nums7, nums8));

        int[] nums9 = {1, 2, 3, 4, 5};
        int[] nums10 = {6, 7, 8, 9, 1};
        assertTrue(ValuesInCommon.valuesInCommon(nums9, nums10));
    }

}