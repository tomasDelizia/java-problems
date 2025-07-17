package com.tomasdelizia.stack;

public class MinStack<T> {
    private int height;
    private Node<T> top;

    public MinStack(T value) {
        top = new Node<>(value);
        top.minValue = value;
        height = 1;
    }

    public MinStack() {
        height = 0;
    }

    public int getHeight() {
        return height;
    }

    public T getTop() {
        if (height == 0) {
            return null;
        }
        return top.value;
    }

    public void push(T value) {
        Node<T> node = new Node<>(value);
        if (height == 0) {
            top = node;
            top.minValue = value;
            height++;
            return;
        }
        node.next = top;
        top = node;
        height++;
        top.minValue = compare(value, node.next.minValue) < 0 ? value : node.next.minValue;
    }

    @SuppressWarnings("unchecked")
    private int compare(Object k1, Object k2) {
        return ((Comparable<? super T>) k1).compareTo((T) k2);
    }

    public T pop() {
        if (height == 0) {
            return null;
        }
        Node<T> temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp.value;
    }

    public T getMinValue() {
        if (height == 0) {
            return null;
        }
        return top.minValue;
    }

    public void printStack() {
        Node<T> current = top;
        while (current != null) {
            System.out.print(current + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static class Node<T> {
        private final T value;
        private Node<T> next;
        private T minValue;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value.toString();
        }
    }
}
