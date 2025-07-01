package com.tomasdelizia.tree;

import java.util.Comparator;
import java.util.Objects;

public class BinarySearchTree<T> {
    private final Comparator<? super T> comparator;
    private Node<T> root;

    public BinarySearchTree() {
        comparator = null;
    }

    public BinarySearchTree(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public boolean insert(T value) {
        Node<T> node = new Node<>(value);
        if (root == null) {
            root = node;
            return true;
        }
        Node<T> current = root;
        while (true) {
            int compare = compare(value, current.value);
            // Can't insert if it already exists
            if (compare == 0) {
                return false;
            }
            // The inserted value is less than the current node, insert to the left
            else if (compare < 0) {
                // Add the node to the left branch if it's empty
                if (current.left == null) {
                    current.left = node;
                    return true;
                }
                // Else, we update the current node to that of the node on the left
                current = current.left;
            }
            // The inserted value is greater than the current node, insert to the right
            else {
                if (current.right == null) {
                    current.right = node;
                    return true;
                }
                current = current.right;
            }
        }
    }

    public boolean contains(T value) {
        Node<T> current = root;
        while (current != null) {
            int compare = compare(value, current.value);
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private int compare(Object k1, Object k2) {
        return (comparator != null) ? comparator.compare((T) k1, (T) k2)
                : ((Comparable<? super T>) k1).compareTo((T) k2);
    }

    public static class Node<T> {
        private final T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
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
    }
}
