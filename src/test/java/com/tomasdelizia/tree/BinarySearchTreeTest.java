package com.tomasdelizia.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

}