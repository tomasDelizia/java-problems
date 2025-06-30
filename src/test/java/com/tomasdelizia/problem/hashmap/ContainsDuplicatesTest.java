package com.tomasdelizia.problem.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicatesTest {
    @Test
    void containsDuplicate() {
        int[] nums1 = {1, 2, 3, 1};
        assertTrue(ContainsDuplicates.containsDuplicate(nums1));

        int[] nums2 = {1, 2, 3, 4};
        assertFalse(ContainsDuplicates.containsDuplicate(nums2));

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertFalse(ContainsDuplicates.containsDuplicate(nums3));

        int[] nums4 = {1};
        assertFalse(ContainsDuplicates.containsDuplicate(nums4));

        int[] nums5 = {};
        assertFalse(ContainsDuplicates.containsDuplicate(nums5));
    }

}