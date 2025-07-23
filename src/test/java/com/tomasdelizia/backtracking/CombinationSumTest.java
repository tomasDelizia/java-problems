package com.tomasdelizia.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumTest {

    @Test
    void testCombinationSum() {
        // Test case with multiple candidates and a target that can be formed by multiple combinations
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        // Expected combinations that sum to the target
        var expected = List.of(
                List.of(2, 2, 3),
                List.of(7)
        );

        var result = CombinationSum.combinationSum(candidates, target);
        assertEquals(expected.size(), result.size());
        for (var combination : expected) {
            assertTrue(result.contains(combination));
        }
    }
}