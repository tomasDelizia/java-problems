package com.tomasdelizia.problem.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoSumTest {

    @Test
    void twoSum() {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = TwoSum.twoSum(nums1, target1);
        // The expected output is the indices of the two numbers that add up to the target
        // It could be [0, 1] or [1, 0] depending on the implementation
        assert result1 != null;
        assertTrue(
                (result1[0] == 0 && result1[1] == 1) ||
                        (result1[0] == 1 && result1[1] == 0)
        );

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = TwoSum.twoSum(nums2, target2);
        assert result2 != null;
        assertTrue(
                (result2[0] == 1 && result2[1] == 2) ||
                        (result2[0] == 2 && result2[1] == 1)
        );

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = TwoSum.twoSum(nums3, target3);
        assert result3 != null;
        assertTrue(
                (result3[0] == 0 && result3[1] == 1) ||
                        (result3[0] == 1 && result3[1] == 0)
        );

        int[] nums4 = {1, 5, 3};
        int target4 = 8;
        int[] result4 = TwoSum.twoSum(nums4, target4);
        assert result4 != null;
        assertTrue(
                (result4[0] == 1 && result4[1] == 2) ||
                        (result4[0] == 2 && result4[1] == 1)
        );

        int[] nums5 = {1, 2, 3, 4, 5};
        int target5 = 10;
        int[] result5 = TwoSum.twoSum(nums5, target5);
        // No two numbers add up to 10, so result should be null
        assertNull(result5);
    }
}