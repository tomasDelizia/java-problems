package com.tomasdelizia.linkedlist;

public class LinkedList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public LinkedList(T value) {
        Node<T> node = new Node<>(value);
        this.head = node;
        this.tail = node;
        this.size = 1;
    }

    public LinkedList() {
        this.size = 0;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void append(T value) {
        Node<T> newNode = new Node<>(value);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void prepend(T value) {
        Node<T> node = new Node<>(value);
        if (size == 0) {
            head = node;
            tail = node;
            size++;
            return;
        }
        node.next = head;
        head = node;
        size++;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node<T> current = head;
        Node<T> pre = head;
        while (current.next != null) {
            pre = current;
            current = current.next;
        }
        tail = pre;
        tail.next = null;
        size--;
        if (size == 0) {
            head = null;
            tail = null;
        }
        return current.value;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node<T> temp = head;
        head = head.next;
        temp.next = null;
        size--;
        if (size == 0) {
            tail = null;
        }
        return temp.value;
    }

    private Node<T> get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> result = head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    public T getValue(int index) {
        Node<T> result = get(index);
        return result != null ? result.value : null;
    }

    public boolean setValue(int index, T value) {
        Node<T> temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insertValue(int index, T value) {
        if (index < 0 || index > size) {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == size) {
            append(value);
            return true;
        }
        Node<T> newNode = new Node<>(value);
        Node<T> temp = get(index - 1);
        if (temp == null) {
            return false;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
        return true;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        Node<T> prev = get(index - 1);
        if (prev == null) {
            return null;
        }
        Node<T> temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        size--;
        return temp.value;
    }

    public void reverse() {
        // Reverse head, tail and all pointers
        if (size == 0) {
            return;
        }
        Node<T> temp = head;
        head = tail;
        tail = temp;
        Node<T> after;
        Node<T> before = null;
        for (int i = 0; i < size; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public T findMiddleValue() {
        if (size == 0) return null;
        Node<T> slow = head, fast = head;
        while (fast.hasNext()) {
            fast = fast.next;
            if (fast.hasNext()) fast = fast.next;
            else return slow.value;
            slow = slow.next;
        }
        return slow.value;
    }

    static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value.toString();
        }

        public boolean hasNext() {
            return next != null;
        }
    }

}
