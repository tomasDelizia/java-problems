package com.tomasdelizia.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TreeSearcherTest {
    @Test
    void dfsWithNullElement() {
        TreeNode<Integer> head = new TreeNode<>(1, null, null);
        TreeSearcher<Integer> searcher = new TreeSearcher<>();
        assertFalse(searcher.dfs(head, null));
    }

    @Test
    void dfsWithSingleNodeTree() {
        TreeNode<Integer> head = new TreeNode<>(1, null, null);
        TreeSearcher<Integer> searcher = new TreeSearcher<>();
        assertTrue(searcher.dfs(head, 1));
    }

    @Test
    void dfsWithElementInTree() {
        TreeNode<Integer> leftChild = new TreeNode<>(2, null, null);
        TreeNode<Integer> rightChild = new TreeNode<>(3, null, null);
        TreeNode<Integer> head = new TreeNode<>(1, leftChild, rightChild);
        TreeSearcher<Integer> searcher = new TreeSearcher<>();
        assertTrue(searcher.dfs(head, 2));
    }

    @Test
    void dfsWithElementNotInTree() {
        TreeNode<Integer> leftChild = new TreeNode<>(2, null, null);
        TreeNode<Integer> rightChild = new TreeNode<>(3, null, null);
        TreeNode<Integer> head = new TreeNode<>(1, leftChild, rightChild);
        TreeSearcher<Integer> searcher = new TreeSearcher<>();
        assertFalse(searcher.dfs(head, 4));
    }

    @Test
    void dfsWithMultipleLevels() {
        TreeNode<Integer> rightChild = new TreeNode<>(3, null, null);
        TreeNode<Integer> leftLeftChild = new TreeNode<>(4, null, null);
        TreeNode<Integer> leftChild = new TreeNode<>(2, leftLeftChild, null);
        TreeNode<Integer> head = new TreeNode<>(1, leftChild, rightChild);
        TreeSearcher<Integer> searcher = new TreeSearcher<>();
        assertTrue(searcher.dfs(head, 4));
    }
}