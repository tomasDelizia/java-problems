package com.tomasdelizia.stack;

public class Stack<T> {
    private int height;
    private Node<T> top;

    public Stack(T value) {
        top = new Node<>(value);
        height = 1;
    }

    public Stack() {
        height = 0;
    }

    public int getHeight() {
        return height;
    }

    public T getTop() {
        return top.value;
    }

    public void push(T value) {
        Node<T> node = new Node<>(value);
        if (height == 0) {
            top = node;
            height++;
            return;
        }
        node.next = top;
        top = node;
        height++;
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

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value.toString();
        }
    }
}
