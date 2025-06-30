package com.tomasdelizia.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    private final T data;
    private final List<TreeNode<T>> children;

    public TreeNode(T data, List<TreeNode<T>> children) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        this.data = data;
        if (children == null) {
            throw new IllegalArgumentException("Children cannot be null");
        }
        this.children = children;
    }

    public TreeNode(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        this.data = data;
        this.children = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
