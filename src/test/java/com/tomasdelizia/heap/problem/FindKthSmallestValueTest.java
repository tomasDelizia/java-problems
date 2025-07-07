package com.tomasdelizia.heap.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindKthSmallestValueTest {
    @Test
    void testFindKthSmallestValue() {

        assertEquals(7, FindKthSmallestValue.findKthSmallestValue(new int[]{7, 10, 4, 3, 20, 15}, 3));
        assertEquals(4, FindKthSmallestValue.findKthSmallestValue(new int[]{3, 2, 1, 5, 6, 4}, 4));
        assertEquals(-1, FindKthSmallestValue.findKthSmallestValue(new int[]{}, 1));
        assertEquals(5, FindKthSmallestValue.findKthSmallestValue(new int[]{5}, 1));
    }

}