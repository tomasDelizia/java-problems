package com.tomasdelizia.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {

    @Test
    void reverseUsingString() {
        assertEquals(321, ReverseInteger.reverseUsingString(123));
        assertEquals(-321, ReverseInteger.reverseUsingString(-123));
        assertEquals(0, ReverseInteger.reverseUsingString(1534236469)); // Overflow case
        assertEquals(0, ReverseInteger.reverseUsingString(Integer.MAX_VALUE)); // Overflow case
        assertEquals(0, ReverseInteger.reverseUsingString(Integer.MIN_VALUE)); // Overflow case
        assertEquals(1, ReverseInteger.reverseUsingString(1000)); // Leading zeros
    }

    @Test
    void reverseUsingMath() {
        assertEquals(321, ReverseInteger.reverseUsingMath(123));
        assertEquals(-321, ReverseInteger.reverseUsingMath(-123));
        assertEquals(0, ReverseInteger.reverseUsingMath(1534236469)); // Overflow case
        assertEquals(0, ReverseInteger.reverseUsingMath(Integer.MAX_VALUE)); // Overflow case
        assertEquals(0, ReverseInteger.reverseUsingMath(Integer.MIN_VALUE)); // Overflow case
        assertEquals(1, ReverseInteger.reverseUsingMath(1000)); // Leading zeros
    }
}