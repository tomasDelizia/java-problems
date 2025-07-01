package com.tomasdelizia.doublylinkedlist;

public class DoublyLinkedList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList(T value) {
        Node<T> node = new Node<>(value);
        this.head = node;
        this.tail = node;
        this.size = 1;
    }

    public DoublyLinkedList() {
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
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    public void prepend(T value) {
        Node<T> newNode = new Node<>(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node<T> removed = tail;
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return removed.value;
        }
        tail = tail.prev;
        tail.next = null;
        removed.prev = null;
        size--;
        return removed.value;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node<T> temp = head;
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return temp.value;
        }
        head = head.next;
        head.prev = null;
        temp.next = null;
        size--;
        return temp.value;
    }

    private Node<T> get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> result = head;
        if (index < size / 2) {
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
        } else {
            result = tail;
            for (int i = size - 1; i > index; i--) {
                result = result.prev;
            }
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
        Node<T> before = get(index - 1);
        if (before == null) {
            return false;
        }
        Node<T> after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
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
        Node<T> before = get(index - 1);
        if (before == null) {
            return null;
        }
        Node<T> toRemove = before.next;
        Node<T> after = toRemove.next;
        before.next = toRemove.next;
        after.prev = before;
        toRemove.next = null;
        toRemove.prev = null;
        size--;
        return toRemove.value;
    }

    public boolean isPalindrome() {
        Node<T> left = head, right = tail;
        for (int i = 0; i < size / 2; i++) {
            if (!left.value.equals(right.value)) {
                return false;
            }
            left = left.next;
            right = right.prev;
        }
        return true;
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
            temp.prev = after;
            before = temp;
            temp = after;
        }
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

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

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
