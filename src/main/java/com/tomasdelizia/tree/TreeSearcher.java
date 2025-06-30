package com.tomasdelizia.tree;

import java.util.*;

public class TreeSearcher {
    public static <T> boolean dfs(TreeNode<T> head, T element) {
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
            List<TreeNode<T>> children = current.getChildren();
            int n = children.size();
            // We add children in reverse order so that the ones on the left are popped first
            for (int i = n - 1; i >= 0; i--) {
                TreeNode<T> child = children.get(i);
                stack.push(child);
            }
        }
        System.out.println("Visited nodes: " + visited);
        return false;
    }

    public static <T> boolean bfs(TreeNode<T> head, T element) {
        if (element == null) {
            return false;
        }
        List<TreeNode<T>> visited = new ArrayList<>();
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.poll();
            visited.add(current);
            if (current.getData().equals(element)) {
                System.out.println("Visited nodes: " + visited);
                return true;
            }
            List<TreeNode<T>> children = current.getChildren();
            // We add children in order so that the ones on the left are polled first
            for (TreeNode<T> child : children) {
                queue.offer(child);
            }
        }
        System.out.println("Visited nodes: " + visited);
        return false;
    }
}
