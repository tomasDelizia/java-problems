package com.tomasdelizia.hash.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HasUniqueCharsTest {
    @Test
    void testUniqueChars() {
        assertTrue(HasUniqueChars.hasUniqueChars("abcdefg"));
        assertTrue(HasUniqueChars.hasUniqueChars("1234567890"));
        assertTrue(HasUniqueChars.hasUniqueChars("!@#$%^&*()"));
        assertTrue(HasUniqueChars.hasUniqueChars("aBcDeFg"));
        assertTrue(HasUniqueChars.hasUniqueChars(" ")); // Single space is unique
        assertTrue(HasUniqueChars.hasUniqueChars("")); // Empty string is unique
        assertFalse(HasUniqueChars.hasUniqueChars("aabbcc"));
        assertFalse(HasUniqueChars.hasUniqueChars("hello"));
    }

}