package com.tomasdelizia.tree;

import java.util.*;

public class TreeSearcher<T> {
    public boolean dfs(TreeNode<T> head, T element) {
        if (element == null) {
            return false;
        }
        List<TreeNode<T>> visited = new ArrayList<>();
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(head);
        while (!stack.empty()) {
            TreeNode<T> current = stack.pop();
            visited.add(current);
            if (current.getData().equals(element)) {
                System.out.println("Visited nodes: " + visited);
                return true;
            }
            TreeNode<T> rightChild = current.getRightChild();
            TreeNode<T> leftChild = current.getLeftChild();
            // We add the right child first if it exists so that the left one is popped first later.
            if (rightChild != null) {
                stack.push(rightChild);
            }
            if (leftChild != null) {
                stack.push(leftChild);
            }
        }
        System.out.println("Visited nodes: " + visited);
        return false;
    }

    public boolean bfs(TreeNode<T> head, T element) {
        if (element == null) {
            return false;
        }
        List<TreeNode<T>> visited = new ArrayList<>();
        Deque<TreeNode<T>> queue = new LinkedList<>();
        queue.offerFirst(head);
        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.poll();
            visited.add(current);
            if (current.getData().equals(element)) {
                System.out.println("Visited nodes: " + visited);
                return true;
            }
            TreeNode<T> rightChild = current.getRightChild();
            TreeNode<T> leftChild = current.getLeftChild();
            // We add the right child last if it exists so that it is polled after the left one.
            if (leftChild != null) {
                queue.offer(leftChild);
            }
            if (rightChild != null) {
                queue.offer(rightChild);
            }
        }
        System.out.println("Visited nodes: " + visited);
        return false;
    }
}
