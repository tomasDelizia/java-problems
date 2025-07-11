package com.tomasdelizia.array.problem;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {
    @Test
    void testThreeSum() {
        int[] input = new int[]{-1, 0, 1, 2, -1, -4};
        var expected = List.of(
                List.of(-1, -1, 2),
                List.of(-1, 0, 1)
        );
        var result = ThreeSum.threeSum(input);
        assertEquals(expected.size(), result.size());
        for (var triplet : expected) {
            assertTrue(result.contains(triplet));
        }
    }

}