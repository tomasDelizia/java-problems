package com.tomasdelizia.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    @Test
    void testLongestCommonPrefix() {
        assertEquals("c", LongestCommonPrefix.longestCommonPrefix(new String[]{"cir", "car"}));
        assertEquals("a", LongestCommonPrefix.longestCommonPrefix(new String[]{"ab", "a"}));
        assertEquals("fl", LongestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", LongestCommonPrefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        assertEquals("a", LongestCommonPrefix.longestCommonPrefix(new String[]{"a"}));
        assertEquals("ab", LongestCommonPrefix.longestCommonPrefix(new String[]{"ab", "ab", "ab"}));
    }
}