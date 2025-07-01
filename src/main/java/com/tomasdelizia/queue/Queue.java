package com.tomasdelizia.queue;

public class Queue<T> {
    private int length;
    private Node<T> first;
    private Node<T> last;

    public Queue(T value) {
        Node<T> node = new Node<>(value);
        first = node;
        last = node;
        length = 1;
    }

    public Queue() {
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public T getFirst() {
        return first.value;
    }

    public T getLast() {
        return last.value;
    }

    public void printQueue() {
        Node<T> current = first;
        while (current != null) {
            System.out.print(current + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void enqueue(T value) {
        Node<T> node = new Node<>(value);
        if (length == 0) {
            first = node;
            last = node;
            length++;
            return;
        }
        last.next = node;
        last = node;
        length++;
    }

    public T dequeue() {
        if (length == 0) {
            return null;
        }
        Node<T> dequeued = first;
        if (length == 1) {
            first = null;
            last = null;
            length--;
            return dequeued.value;
        }
        first = first.next;
        dequeued.next = null;
        length--;
        return dequeued.value;
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
