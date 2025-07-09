package com.tomasdelizia.hash.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {
    @Test
    void testLongestConsecutiveSequence() {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        assertEquals(4, LongestConsecutiveSequence.longestConsecutiveSequence(nums));
    }

}