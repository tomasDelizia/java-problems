package com.tomasdelizia.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    @Test
    void testInsertNode() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertTrue(bst.insert(10));
        assertTrue(bst.insert(5));
        assertTrue(bst.insert(15));
        assertTrue(bst.insert(3));
        assertTrue(bst.insert(7));
        assertTrue(bst.insert(12));
        assertTrue(bst.insert(18));
        assertFalse(bst.insert(10)); // Duplicate insert should return false
        assertFalse(bst.insert(18));  // Duplicate insert should return false
    }

    @Test
    void testInsertNodeWithComparator() {
        // use descending order for the comparator
        BinarySearchTree<Integer> bst = new BinarySearchTree<>((a, b) -> b - a);
        assertTrue(bst.insert(10));
        assertTrue(bst.insert(5));
        assertTrue(bst.insert(15));
        assertTrue(bst.insert(3));
        assertTrue(bst.insert(7));
        assertTrue(bst.insert(12));
        assertTrue(bst.insert(18));
        assertFalse(bst.insert(10)); // Duplicate insert should return false
        assertFalse(bst.insert(18));  // Duplicate insert should return false
    }

    @Test
    void testContains() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        assertTrue(bst.contains(10));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(15));
        assertTrue(bst.contains(3));
        assertTrue(bst.contains(7));
        assertTrue(bst.contains(12));
        assertTrue(bst.contains(18));
        assertFalse(bst.contains(20)); // Value not in the tree
        assertFalse(bst.contains(1));  // Value not in the tree
    }

    @Test
    void testRecursiveInsertContainsAndRemove() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Insert nodes using recursive insert
        bst.rInsert(10);
        bst.rInsert(5);
        bst.rInsert(15);
        bst.rInsert(3);
        bst.rInsert(7);
        bst.rInsert(12);
        bst.rInsert(18);

        // Check if the nodes are present using recursive contains
        assertTrue(bst.rContains(10));
        assertTrue(bst.rContains(5));
        assertTrue(bst.rContains(15));
        assertTrue(bst.rContains(3));
        assertTrue(bst.rContains(7));
        assertTrue(bst.rContains(12));
        assertTrue(bst.rContains(18));
        assertFalse(bst.rContains(20)); // Value not in the tree
        assertFalse(bst.rContains(1));  // Value not in the tree

        // Remove nodes recursively
        bst.remove(10);
        assertFalse(bst.rContains(10)); // 10 should be removed
        bst.remove(5);
        assertFalse(bst.rContains(5));  // 5 should be removed
        bst.remove(15);
        assertFalse(bst.rContains(15)); // 15 should be removed
    }

    @Test
    void testMinValue() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.rInsert(10);
        bst.rInsert(5);
        bst.rInsert(15);
        bst.rInsert(3);
        bst.rInsert(7);
        bst.rInsert(12);
        bst.rInsert(18);
        assertEquals(3, bst.minValue());
    }

    @Test
    void testSortedArrayToBSTOddLength() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] sortedOddLength = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        bst.sortedArrayToBST(sortedOddLength);
        assertTrue(bst.rContains(1));
        assertTrue(bst.rContains(2));
        assertTrue(bst.rContains(3));
        assertTrue(bst.rContains(4));
        assertTrue(bst.rContains(5));
        assertTrue(bst.rContains(6));
        assertTrue(bst.rContains(7));
    }

    @Test
    void testSortedArrayToBSTEvenLength() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] sortedEvenLength = new Integer[]{1, 2, 3, 4, 5, 6};
        bst.sortedArrayToBST(sortedEvenLength);
        assertTrue(bst.rContains(1));
        assertTrue(bst.rContains(2));
        assertTrue(bst.rContains(3));
        assertTrue(bst.rContains(4));
        assertTrue(bst.rContains(5));
        assertTrue(bst.rContains(6));
    }

    @Test
    void testSortedArrayToBSTDuplicates() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] sorted = new Integer[]{1, 1, 2, 3, 4, 5, 5, 6, 7};
        bst.sortedArrayToBST(sorted);
        assertTrue(bst.rContains(1));
        assertTrue(bst.rContains(2));
        assertTrue(bst.rContains(3));
        assertTrue(bst.rContains(4));
        assertTrue(bst.rContains(5));
        assertTrue(bst.rContains(6));
        assertTrue(bst.rContains(7));
    }

    @Test
    void testInvertBST() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] sorted = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        bst.sortedArrayToBST(sorted);
        bst.invert();
    }

    @Test
    void testBfs() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] sorted = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        bst.sortedArrayToBST(sorted);
        List<Integer> visited = bst.bfs();
        List<Integer> expected = List.of(4, 2, 6, 1, 3, 5, 7);
        assertEquals(7, visited.size());
        assertEquals(expected, visited);
    }

    @Test
    void testDfsPreOrder() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] sorted = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        bst.sortedArrayToBST(sorted);
        List<Integer> visited = bst.dfsPreOrder();
        List<Integer> expected = List.of(4, 2, 1, 3, 6, 5, 7);
        assertEquals(7, visited.size());
        assertEquals(expected, visited);
    }

    @Test
    void testRecursiveDfsPreOrder() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] sorted = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        bst.sortedArrayToBST(sorted);
        List<Integer> visited = bst.rDfsPreOrder();
        List<Integer> expected = List.of(4, 2, 1, 3, 6, 5, 7);
        assertEquals(7, visited.size());
        assertEquals(expected, visited);
    }

    @Test
    void testRecursiveDfsPostOrder() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] sorted = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        bst.sortedArrayToBST(sorted);
        List<Integer> visited = bst.rDfsPostOrder();
        List<Integer> expected = List.of(1, 3, 2, 5, 7, 6, 4);
        assertEquals(7, visited.size());
        assertEquals(expected, visited);
    }

    @Test
    void testRecursiveDfsInOrder() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] sorted = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        bst.sortedArrayToBST(sorted);
        List<Integer> visited = bst.rDfsInOrder();
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7);
        assertEquals(7, visited.size());
        assertEquals(expected, visited);
    }

    @Test
    void testIsValidBST() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] sorted = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        bst.sortedArrayToBST(sorted);
        assertTrue(bst.isValidBST());
    }

    @Test
    void testIsValidBSTTwoNodes() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] sorted = new Integer[]{1, 1};
        bst.sortedArrayToBST(sorted);
        assertTrue(bst.isValidBST());
    }

    @Test
    void testKthSmallestWithInOrderDfs() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] sorted = new Integer[]{1, 2, 4, 4, 5, 6, 7};
        bst.sortedArrayToBST(sorted);
        int kthSmallest = bst.kthSmallest(3);
        assertEquals(4, kthSmallest);
    }
}