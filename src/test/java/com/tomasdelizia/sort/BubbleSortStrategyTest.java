package com.tomasdelizia.sort;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BubbleSortStrategyTest {
    private final Sorter<Integer> sorter = new BubbleSortStrategy<>();
    private final Sorter<Integer> descSorter = new BubbleSortStrategy<>((a, b) -> b - a);

    @Test
    void bubbleSortWithEmptyArray() {
        Integer[] nums = {};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{}, nums);
    }

    @Test
    void bubbleSortWithSingleElementArray() {
        Integer[] nums = {5};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{5}, nums);
    }

    @Test
    void bubbleSortWithMultipleElements() {
        Integer[] nums = {5, 3, 8, 1, 2};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{1, 2, 3, 5, 8}, nums);

        nums = new Integer[]{10, -1, 0, 5};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{-1, 0, 5, 10}, nums);

        nums = new Integer[]{7, 7, 7};
        sorter.sort(nums);
        assertArrayEquals(new Integer[]{7, 7, 7}, nums);
    }

    @Test
    void bubbleSortWithDescendingOrder() {
        Integer[] nums = {5, 3, 8, 1, 2};
        descSorter.sort(nums);
        assertArrayEquals(new Integer[]{8, 5, 3, 2, 1}, nums);

        nums = new Integer[]{10, -1, 0, 5};
        descSorter.sort(nums);
        assertArrayEquals(new Integer[]{10, 5, 0, -1}, nums);

        nums = new Integer[]{7, 7, 7};
        descSorter.sort(nums);
        assertArrayEquals(new Integer[]{7, 7, 7}, nums);
    }

    @Test
    void bubbleSortWithLinkedList() {
        List<Integer> nums = new LinkedList<>(List.of(5, 3, 8, 1, 2));
        sorter.sort(nums);
        assertEquals(List.of(1, 2, 3, 5, 8), nums);
    }

}