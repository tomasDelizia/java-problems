package com.tomasdelizia.problem.hashmap;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FindDuplicatesTest {
    @Test
    void testFindDuplicates() {
        int[] nums1 = {1, 2, 3, 4, 5};
        assertTrue(FindDuplicates.findDuplicates(nums1).isEmpty());

        int[] nums2 = {1, 2, 3, 4, 5, 1};
        assertEquals(FindDuplicates.findDuplicates(nums2), List.of(1));

        int[] nums3 = {1, 2, 3, 4, 5, 2};
        assertEquals(FindDuplicates.findDuplicates(nums3), List.of(2));

        int[] nums4 = {1, 2, 3, 4, 5, 1, 2};
        assertEquals(FindDuplicates.findDuplicates(nums4), List.of(1, 2));

        int[] nums5 = {};
        assertTrue(FindDuplicates.findDuplicates(nums5).isEmpty());
    }

}