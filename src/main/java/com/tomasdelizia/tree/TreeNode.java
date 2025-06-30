package com.tomasdelizia.tree;

public class TreeNode<T> {
    private final T data;
    private final TreeNode<T> leftChild;
    private final TreeNode<T> rightChild;

    public TreeNode(T data, TreeNode<T> leftChild, TreeNode<T> rightChild) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
