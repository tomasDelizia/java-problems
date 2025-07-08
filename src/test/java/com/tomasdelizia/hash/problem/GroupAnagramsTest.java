package com.tomasdelizia.hash.problem;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupAnagramsTest {
    @Test
    void testGroupAnagrams() {
        String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected1 = List.of(
                List.of("eat", "tea", "ate"),
                List.of("tan", "nat"),
                List.of("bat")
        );
        List<List<String>> result = GroupAnagrams.groupAnagrams(input1);
        assertTrue(result.containsAll(expected1));

        String[] input2 = {"a"};
        List<List<String>> expected2 = List.of(List.of("a"));
        assertEquals(expected2, GroupAnagrams.groupAnagrams(input2));

        String[] input3 = {};
        List<List<String>> expected3 = List.of();
        assertEquals(expected3, GroupAnagrams.groupAnagrams(input3));
    }
}