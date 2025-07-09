package com.tomasdelizia.hash.problem;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindPairsTest {
    @Test
    void testFindPairs() {
        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        int[] nums2 = new int[]{2, 4, 6, 8, 10};
        int target = 7;
        List<int[]> result = FindPairs.findPairs(nums1, nums2, target);
        assertEquals(3, result.size());
    }

}