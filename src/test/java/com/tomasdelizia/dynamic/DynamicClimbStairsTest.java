package com.tomasdelizia.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicClimbStairsTest {

    @Test
    void testClimbStairs() {
        assertEquals(1, DynamicClimbStairs.climbStairs(1));
        assertEquals(2, DynamicClimbStairs.climbStairs(2));
        assertEquals(3, DynamicClimbStairs.climbStairs(3));
        assertEquals(5, DynamicClimbStairs.climbStairs(4));
        assertEquals(8, DynamicClimbStairs.climbStairs(5));
        assertEquals(13, DynamicClimbStairs.climbStairs(6));
        assertEquals(21, DynamicClimbStairs.climbStairs(7));
        assertEquals(34, DynamicClimbStairs.climbStairs(8));
        assertEquals(55, DynamicClimbStairs.climbStairs(9));
        assertEquals(89, DynamicClimbStairs.climbStairs(10));
    }
}