package com.tomasdelizia.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeedleInHaystackTest {

    @Test
    void testStrStr() {
        assertEquals(2, NeedleInHaystack.strStr("hello", "ll"));
        assertEquals(-1, NeedleInHaystack.strStr("aaaaa", "bba"));
        assertEquals(0, NeedleInHaystack.strStr("hello", ""));
        assertEquals(0, NeedleInHaystack.strStr("", ""));
        assertEquals(-1, NeedleInHaystack.strStr("", "a"));
        assertEquals(0, NeedleInHaystack.strStr("abc", "abc"));
        assertEquals(4, NeedleInHaystack.strStr("mississippi", "issip"));
    }
}