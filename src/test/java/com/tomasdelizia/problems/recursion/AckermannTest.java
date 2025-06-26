package com.tomasdelizia.problems.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AckermannTest {
    @Test
    void testAckermann() {
        assertEquals(1, Ackermann.ackermann(0, 0));
        assertEquals(3, Ackermann.ackermann(1, 1));
        assertEquals(7, Ackermann.ackermann(2, 2));
        assertEquals(509, Ackermann.ackermann(3, 6));
        assertEquals(65533, Ackermann.ackermann(4, 1));
    }

}