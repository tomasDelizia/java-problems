package com.tomasdelizia.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToIntegerTest {

    @Test
    void testStringToInteger() {
        assertEquals(42, StringToInteger.toInteger("42"));
        assertEquals(-42, StringToInteger.toInteger("  -042"));
        assertEquals(1337, StringToInteger.toInteger("1337c0d3 "));
        assertEquals(0, StringToInteger.toInteger("0-1"));
        assertEquals(0, StringToInteger.toInteger("  words and 987"));
        assertEquals(Integer.MAX_VALUE, StringToInteger.toInteger("9223372036854775808"));
    }
}