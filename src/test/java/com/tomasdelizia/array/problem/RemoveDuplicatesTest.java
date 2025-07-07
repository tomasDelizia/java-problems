package com.tomasdelizia.array.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {
    @Test
    void testRemoveDuplicates() {
        int[] nums1 = {1, 1, 2};
        int expectedLength1 = 2;
        int[] expectedArray1 = {1, 2};
        assertEquals(expectedLength1, RemoveDuplicates.removeDuplicates(nums1));
        assertArrayEquals(expectedArray1, new int[]{nums1[0], nums1[1]});

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int expectedLength2 = 5;
        int[] expectedArray2 = {0, 1, 2, 3, 4};
        assertEquals(expectedLength2, RemoveDuplicates.removeDuplicates(nums2));
        assertArrayEquals(expectedArray2, new int[]{nums2[0], nums2[1], nums2[2], nums2[3], nums2[4]});
    }

}