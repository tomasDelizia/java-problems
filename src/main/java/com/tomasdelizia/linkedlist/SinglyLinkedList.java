package com.tomasdelizia.linkedlist;

public class SinglyLinkedList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public SinglyLinkedList(T value) {
        Node<T> node = new Node<>(value);
        this.head = node;
        this.tail = node;
        this.size = 1;
    }

    public SinglyLinkedList() {
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

    public int size() {
        return size;
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

    /**
     * Converts a binary linked list to decimal.
     * @param binaryList A linked list where each node contains a binary digit (0 or 1).
     * @return The decimal representation of the binary number.
     */
    public static long binaryToDecimal(SinglyLinkedList<Integer> binaryList) {
        long result = 0;
        Node<Integer> current = binaryList.head;
        while (current != null) {
            result *= 2;
            if (current.value.equals(1)) result += 1;
            current = current.next;
        }
        return result;
    }

    /**
     * Partitions the list into two parts: one with values less than x and the other with values greater than or equal to x.
     * @param x the value to partition the list around
     */
    public void partition(T x) {
        if (head == null) return;
        // For values < x
        Node<T> dummy1 = new Node<>(null);
        // For values >= x
        Node<T> dummy2 = new Node<>(null);

        // Pointers to build the two lists.
        Node<T> prev1 = dummy1;
        Node<T> prev2 = dummy2;
        Node<T> current = head;

        // Traverse the list and partition nodes into two lists.
        while (current != null) {
            int compare = compare(current.value, x);
            if (compare < 0) {
                // Attach node to dummy1.
                prev1.next = current;
                prev1 = current;
            } else {
                // Attach node to dummy2.
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }

        // Terminate the second list.
        prev2.next = null;

        // Connect the two lists.
        prev1.next = dummy2.next;
        
        // Update the head pointer of the main list.
        head = dummy1.next;

        // Update the tail pointer if the second list is not empty.
        if (dummy2.next != null) {
            tail = prev2;
        } else {
            tail = prev1; // If no nodes in dummy2, tail is the last node of dummy1.
        }
    }

    /**
     * Reverses the sublist between startIndex and endIndex (inclusive).
     * @param startIndex the starting index of the sublist to reverse
     * @param endIndex the ending index of the sublist to reverse
     */
    public void reverseBetween(int startIndex, int endIndex) {
        if (startIndex >= endIndex || size == 0) return;

        // Create dummy node before head to simplify edge cases and zero indexing.
        Node<T> dummy = new Node<>(null);
        dummy.next = head;

        // Move prev to the node before startIndex
        Node<T> prev = dummy;
        for (int i = 0; i < startIndex; i++) prev = prev.next;

        // Start reversing from prev.next
        Node<T> current = prev.next;

        int steps = endIndex - startIndex;
        for (int i = 0; i < steps; i++) {
            Node<T> toMove = current.next;

            // Remove toModeFrom its place
            current.next = toMove.next;

            // Move toMove to the front of the sublist.
            toMove.next = prev.next;

            prev.next = toMove;
        }
        // Update the head in the case it changed.
        head = dummy.next;
        // Update the tail if necessary.
        if (endIndex == size - 1) {
            tail = current; // If we reversed till the end, update tail.
        }
    }

    /**
     * Swaps every two adjacent nodes in the list.
     * Leaves the last node unchanged if the list has an odd number of nodes.
     */
    public void swapPairs() {
        // Create dummy node to simplify process and connect it to the head.
        Node<T> dummy = new Node<>(null);
        dummy.next = head;
        // Create prev that will always point to the node before the pair of nodes to swap.
        Node<T> prev = dummy;

        // Loop while there are two nodes to swap.
        while (head != null && head.next != null) {
            Node<T> first = head;
            Node<T> second = head.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            head = first.next;
            prev = first;
        }
        // Exclude the dummy node from the list.
        head = dummy.next;
        tail = prev; // Update tail to the last processed node.
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

    public void merge(SinglyLinkedList<T> other) {
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
