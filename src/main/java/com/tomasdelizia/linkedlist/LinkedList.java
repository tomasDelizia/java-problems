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
        if (size == 0) {
            return null;
        }
        Node<T> slow = head, fast = head;
        while (fast.hasNext()) {
            fast = fast.next;
            if (fast.hasNext()) {
                fast = fast.next;
            } else {
                return slow.value;
            }
            slow = slow.next;
        }
        return slow.value;
    }

    public boolean hasLoop() {
        if (size == 0) {
            return false;
        }
        Node<T> slow = head, fast = head;
        while (fast.hasNext()) {
            fast = fast.next;
            if (fast.hasNext()) {
                fast = fast.next;
            } else {
                return false;
            }
            slow = slow.next;
            if (slow.value.equals(fast.value)) {
                return true;
            }
        }
        return false;
    }

    public T findKthFromEnd(int k) {
        if (head == null) {
            return null;
        }
        if (k == 1) {
            return tail.value;
        }
        Node<T> slow = head, fast = head;
        while (fast.hasNext()) {
            for (int i = 0; i < k - 1; i++) {
                if (!fast.hasNext()) {
                    return null;
                }
                fast = fast.next;
            }
            if (fast.hasNext()) {
                slow = slow.next;
            }
        }
        return slow.value;
    }

    public void bubbleSort() {
        if (size < 2) {
            return;
        }
        Node<T> sortedUntil = null;
        while (sortedUntil != head.next) {
            Node<T> current = head;
            while (current.next != sortedUntil) {
                Node<T> next = current.next;
                int compare = compare(current.value, next.value);
                if (compare > 0) {
                    T temp = current.value;
                    current.value = next.value;
                    next.value = temp;
                }
                current = current.next;
            }
            sortedUntil = current;
        }
    }

    public void selectionSort() {
        if (size <= 2) {
            return;
        }
        Node<T> current = head;
        while (current != null && current.hasNext()) {
            Node<T> smallest = current;
            Node<T> innerCurrent = current.next;
            while (innerCurrent != null) {
                int compare = compare(innerCurrent.value, smallest.value);
                if (compare < 0) {
                    smallest = innerCurrent;
                }
                innerCurrent = innerCurrent.next;
            }
            if (smallest != current) {
                T temp = smallest.value;
                smallest.value = current.value;
                current.value = temp;
            }
            current = current.next;
        }
        tail = current;
    }

    public void insertionSort() {
        if (size <= 2) {
            return;
        }
        Node<T> sortedListHead = head;
        Node<T> unsortedListHead = head.next;
        // Detach sorted part from sorted part
        sortedListHead.next = null;
        while (unsortedListHead != null) {
            Node<T> current = unsortedListHead;
            unsortedListHead = unsortedListHead.next;
            int compare = compare(current.value, sortedListHead.value);
            if (compare < 0) {
                current.next = sortedListHead;
                sortedListHead = current;
            } else {
                Node<T> searchPointer = sortedListHead;
                while (searchPointer.hasNext() && compare(current.value, searchPointer.next.value) > 0) {
                    searchPointer = searchPointer.next;
                }
                current.next = searchPointer.next;
                searchPointer.next = current;
            }
        }
        head = sortedListHead;
        Node<T> temp = head;
        while (temp.hasNext()) {
            temp = temp.next;
        }
        tail = temp;
    }

    public void merge(LinkedList<T> other) {
        Node<T> otherHead = other.head;
        Node<T> dummy = new Node<>(null);
        Node<T> current = dummy;
        while (head != null && otherHead != null) {
            int compare = compare(head.value, otherHead.value);
            if (compare < 0) {
                current.next = head;
                head = head.next;
            } else {
                current.next = otherHead;
                otherHead = otherHead.next;
            }
            current = current.next;
        }
        if (head != null) {
            current.next = head;
        } else {
            current.next = otherHead;
            tail = other.tail;
        }
        head = dummy.next;
        size += other.size;
    }

    @SuppressWarnings("unchecked")
    private int compare(Object k1, Object k2) {
        return ((Comparable<? super T>) k1).compareTo((T) k2);
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
