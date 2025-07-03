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

    public boolean rContains(T value) {
        return rContains(root, value);
    }

    private boolean rContains(Node<T> currentNode, T value) {
        if (currentNode == null) {
            return false;
        }
        int compare = compare(value, currentNode.value);
        if (compare == 0) {
            return true;
        }
        if (compare < 0) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    public void rInsert(T value) {
        if (root == null) {
            root = new Node<>(value);
        }
        rInsert(root, value);
    }

    private Node<T> rInsert(Node<T> currentNode, T value) {
        if (currentNode == null) {
            return new Node<>(value);
        }
        int compare = compare(value, currentNode.value);
        if (compare < 0) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (compare > 0) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void remove(T value) {
        remove(root, value);
    }

    private Node<T> remove(Node<T> currentNode, T value) {
        // The value is not in the tree
        if (currentNode == null) {
            return null;
        }

        int compare = compare(value, currentNode.value);
        if (compare < 0) {
            currentNode.left = remove(currentNode.left, value);
        } else if (compare > 0) {
            currentNode.right = remove(currentNode.right, value);
        }
        // Found the node to remove
        else {
            // Check if it's a leaf node (childless) and make it null by returning a null pointer
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            }
            // Else check if it has a left or child and swap so that it gets garbage collected
            else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            }
            // Else the node to remove has two children
            else {
                T subTreeMinValue = minValue(currentNode.right);
                // Swap the current node value with its min value and delete the subTree node.
                currentNode.value = subTreeMinValue;
                currentNode.right = remove(currentNode.right, subTreeMinValue);
            }
        }
        return currentNode;
    }

    public T minValue() {
        return minValue(root);
    }

    private T minValue(Node<T> currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public void sortedArrayToBST(T[] values) {
        root = sortedArrayToBST(values, 0, values.length - 1);
    }

    private Node<T> sortedArrayToBST(T[] values, int left, int right) {
        // End of branch
        if (left > right) {
            return null;
        }
        int center = (left + right) / 2;
        Node<T> current = new Node<>(values[center]);
        current.left = sortedArrayToBST(values, left, center - 1);
        current.right = sortedArrayToBST(values, center + 1, right);
        return current;
    }

    public void invert() {
        root = invert(root);
    }

    private Node<T> invert(Node<T> node) {
        if (node == null) {
            return null;
        }
        Node<T> temp = node.left;
        node.left = invert(node.right);
        node.right = invert(temp);
        return node;
    }

    @SuppressWarnings("unchecked")
    private int compare(Object k1, Object k2) {
        return (comparator != null) ? comparator.compare((T) k1, (T) k2)
                : ((Comparable<? super T>) k1).compareTo((T) k2);
    }

    public static class Node<T> {
        private T value;
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
