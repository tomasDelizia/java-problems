package com.tomasdelizia.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TreeSearcherTest {
    @Test
    void dfsWithNullElement() {
        TreeNode<Integer> head = new TreeNode<>(1);
        assertFalse(TreeSearcher.dfs(head, null));
    }

    @Test
    void dfsWithSingleNodeTree() {
        TreeNode<Integer> head = new TreeNode<>(1);
        assertTrue(TreeSearcher.dfs(head, 1));
    }

    @Test
    void dfsWithElementInTree() {
        TreeNode<Integer> leftChild = new TreeNode<>(2);
        TreeNode<Integer> rightChild = new TreeNode<>(3);
        TreeNode<Integer> head = new TreeNode<>(1, List.of(leftChild, rightChild));
        assertTrue(TreeSearcher.dfs(head, 2));
    }

    @Test
    void dfsWithElementNotInTree() {
        TreeNode<Integer> leftChild = new TreeNode<>(2);
        TreeNode<Integer> rightChild = new TreeNode<>(3);
        TreeNode<Integer> head = new TreeNode<>(1, List.of(leftChild, rightChild));
        assertFalse(TreeSearcher.dfs(head, 4));
    }

    @Test
    void dfsWithMultipleLevels() {
        TreeNode<Integer> rightChild = new TreeNode<>(3);
        TreeNode<Integer> leftLeftChild = new TreeNode<>(4);
        TreeNode<Integer> leftChild = new TreeNode<>(2, List.of(leftLeftChild));
        TreeNode<Integer> head = new TreeNode<>(1, List.of(leftChild, rightChild));
        assertTrue(TreeSearcher.dfs(head, 4));
    }

    @Test
    void bfsWithMultipleLevels() {
        TreeNode<Integer> rightChild = new TreeNode<>(3);
        TreeNode<Integer> leftLeftChild = new TreeNode<>(5);
        TreeNode<Integer> leftChild = new TreeNode<>(2, List.of(leftLeftChild));
        TreeNode<Integer> head = new TreeNode<>(1, List.of(leftChild, rightChild));
        assertTrue(TreeSearcher.bfs(head, 3));
    }
}