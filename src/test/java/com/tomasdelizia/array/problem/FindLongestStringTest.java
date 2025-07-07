package com.tomasdelizia.array.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindLongestStringTest {
    @Test
    void testFindLongesttring() {
        String[] strings = {"apple", "banana", "cherry", "date"};
        String expected = "banana";
        String actual = FindLongestString.findLongestString(strings);
        assertEquals(expected, actual);
    }

}