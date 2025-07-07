package com.tomasdelizia.tree;

import java.util.*;

public class NAryTree<T> {
    private final Node<T> root;

    public NAryTree(T root) {
        if (root == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        this.root = new Node<>(root);
    }

    @Override
    public String toString() {
        return root.toString();
    }

    public List<T> dfs() {
        List<T> visited = new ArrayList<>();
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node<T> current = stack.pop();
            visited.add(current.value);
            List<Node<T>> children = current.getChildren();
            int n = children.size();
            // We add children in reverse order so that the ones on the left are popped first
            for (int i = n - 1; i >= 0; i--) {
                Node<T> child = children.get(i);
                stack.push(child);
            }
        }
        System.out.println("Visited nodes: " + visited);
        return visited;
    }

    public void addChildrenToNode(T node, List<T> children) {
        Node<T> element = dfsFind(node);
        if (element == null) return;
        element.setChildren(children);
    }

    private Node<T> dfsFind(T element) {
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node<T> current = stack.pop();
            if (current.value.equals(element)) return current;
            List<Node<T>> children = current.getChildren();
            int n = children.size();
            // We add children in reverse order so that the ones on the left are popped first
            for (int i = n - 1; i >= 0; i--) {
                Node<T> child = children.get(i);
                stack.push(child);
            }
        }
        return null;
    }

    public List<T> bfs() {
        List<T> visited = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            visited.add(current.value);
            List<Node<T>> children = current.getChildren();
            // We add children in order so that the ones on the left are polled first
            for (Node<T> child : children) {
                queue.offer(child);
            }
        }
        System.out.println("Visited nodes: " + visited);
        return visited;
    }

    public static class Node<T> {
        private final T value;
        private List<Node<T>> children;

        public Node(T value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

        public void setChildren(List<T> children) {
            this.children = children.stream().filter(Objects::nonNull).map(Node::new).toList();
        }

        @Override
        public String toString() {
            return this.value.toString();
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 61 * hash + this.value.hashCode();
            return hash;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            return Objects.equals(this.value, ((Node<?>) o).value);
        }

        public List<Node<T>> getChildren() {
            return children;
        }
    }
}
