package com.tomasdelizia.sort;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedListsTest {

    @Test
    void testMergeSortedLists() {
        // Test case with multiple sorted lists
        List<List<String>> lists = List.of(
                List.of("apple", "banana", "cherry"),
                List.of("apricot", "blueberry"),
                List.of("avocado", "kiwi")
        );

        List<String> expected = List.of(
                "apple", "apricot", "avocado", "banana", "blueberry", "cherry", "kiwi"
        );

        List<String> result = MergeSortedLists.mergeSortedLists(lists);
        assertEquals(expected, result);
    }
}