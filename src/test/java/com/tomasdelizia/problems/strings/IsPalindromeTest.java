package com.tomasdelizia.problems.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsPalindromeTest {
    @Test
    void testIsPalindromeWithForLoop() {
        assertTrue(IsPalindrome.isPalindromeWithForLoop("hallah"));
        assertTrue(IsPalindrome.isPalindromeWithForLoop("racecar"));
        assertTrue(IsPalindrome.isPalindromeWithForLoop(""));
        assertTrue(IsPalindrome.isPalindromeWithForLoop("a"));
        assertFalse(IsPalindrome.isPalindromeWithForLoop("hello"));
    }

    @Test
    void testIsPalindromeFromExtremes() {
        assertTrue(IsPalindrome.isPalindromeFromExtremes("hallah"));
        assertTrue(IsPalindrome.isPalindromeFromExtremes("racecar"));
        assertTrue(IsPalindrome.isPalindromeFromExtremes(""));
        assertTrue(IsPalindrome.isPalindromeFromExtremes("a"));
        assertFalse(IsPalindrome.isPalindromeFromExtremes("hello"));
    }

    @Test
    void testIsPalindromeFromMiddle() {
        assertTrue(IsPalindrome.isPalindromeFromMiddle("hallah"));
        assertTrue(IsPalindrome.isPalindromeFromMiddle("racecar"));
        assertTrue(IsPalindrome.isPalindromeFromMiddle(""));
        assertTrue(IsPalindrome.isPalindromeFromMiddle("a"));
        assertFalse(IsPalindrome.isPalindromeFromMiddle("hello"));
    }

}