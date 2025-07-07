package com.tomasdelizia.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {
    @Test
    void testLinkedList() {
        // Test creating a linked list with a single element
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(5);
        list.printList();
        // Test append
        list.append(10);
        list.printList();
        assertEquals(10, list.removeLast());
        list.printList();
        assertEquals(5, list.removeLast());
        list.printList();
        // Test prepend
        list.prepend(20);
        list.printList();
        list.prepend(5);
        list.printList();
        assertEquals(5, list.removeFirst());
        list.printList();
        assertEquals(20, list.removeFirst());
        list.printList();
        assertNull(list.removeFirst());
    }

    @Test
    void testGetByIndex() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        assertEquals(1, list.getValue(0));
        assertEquals(2, list.getValue(1));
        assertEquals(3, list.getValue(2));
        assertNull(list.getValue(3)); // Out of bounds
    }

    @Test
    void testSetByIndexAndValue() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        assertTrue(list.setValue(1, 20));
        assertEquals(20, list.getValue(1));
        assertTrue(list.setValue(0, 10));
        assertEquals(10, list.getValue(0));
        assertTrue(list.setValue(2, 30));
        assertEquals(30, list.getValue(2));
        // Attempt to set an out-of-bounds index
        assertFalse(list.setValue(3, 40)); // Should not change anything
        assertNull(list.getValue(3));
    }

    @Test
    void testInsertByIndexAndValue() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(3);
        list.insertValue(1, 2); // Insert 2 at index 1
        assertEquals(2, list.getValue(1));
        assertEquals(3, list.getValue(2));
        // Attempt to insert at an out-of-bounds index
        assertFalse(list.insertValue(5, 4)); // Should not change anything
        assertNull(list.getValue(5));
    }

    @Test
    void testRemoveAtIndex() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        assertEquals(2, list.remove(1)); // Remove at index 1
        assertEquals(1, list.getValue(0));
        assertEquals(3, list.getValue(1));
        // Attempt to remove at an out-of-bounds index
        assertNull(list.remove(5)); // Should return null
        assertNull(list.getValue(5));
    }

    @Test
    void testReverse() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        System.out.println("Original list:");
        list.printList();
        list.reverse();
        System.out.println("Reversed list:");
        list.printList();
        assertEquals(3, list.getValue(0));
        assertEquals(2, list.getValue(1));
        assertEquals(1, list.getValue(2));

        // Test reversing an empty list
        SinglyLinkedList<Integer> emptyList = new SinglyLinkedList<>();
        emptyList.reverse();
        assertNull(emptyList.getValue(0)); // Should still be empty
    }

    @Test
    void testFindMiddleValue() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        Integer middleValue = list.findMiddleValue();
        assertEquals(3, middleValue);

        list.clear();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        middleValue = list.findMiddleValue();
        assertEquals(2, middleValue);

        list.clear();
        assertNull(list.findMiddleValue());

        list.append(1);
        middleValue = list.findMiddleValue();
        assertEquals(1, middleValue);
    }

    @Test
    void testHasLoop() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        assertFalse(list.hasLoop());

        // Create a loop for testing
        SinglyLinkedList.Node<Integer> node1 = new SinglyLinkedList.Node<>(4);
        SinglyLinkedList.Node<Integer> node2 = new SinglyLinkedList.Node<>(5);
        node1.setNext(node2);
        node2.setNext(node1); // Creates a loop
        list.setHead(node1);
        list.setTail(node2);
        assertTrue(list.hasLoop());

        // Test with an empty list
        SinglyLinkedList<Integer> emptyList = new SinglyLinkedList<>();
        assertFalse(emptyList.hasLoop());
    }

    @Test
    void testFindKthFromEnd() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        assertEquals(3, list.findKthFromEnd(1)); // Last element
        assertEquals(2, list.findKthFromEnd(2)); // Second last element
        assertEquals(1, list.findKthFromEnd(3)); // Third last element
        assertNull(list.findKthFromEnd(4)); // Out of bounds

        // Test with an empty list
        SinglyLinkedList<Integer> emptyList = new SinglyLinkedList<>();
        assertNull(emptyList.findKthFromEnd(1));
    }

    @Test
    void testBubbleSort() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(5);
        list.append(3);
        list.append(8);
        list.append(1);
        list.append(2);

        list.bubbleSort();

        assertEquals(1, list.removeFirst());
        assertEquals(2, list.removeFirst());
        assertEquals(3, list.removeFirst());
        assertEquals(5, list.removeFirst());
        assertEquals(8, list.removeFirst());
    }

    @Test
    void testSelectionSort() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(5);
        list.append(3);
        list.append(8);
        list.append(1);
        list.append(2);

        list.selectionSort();

        assertEquals(1, list.removeFirst());
        assertEquals(2, list.removeFirst());
        assertEquals(3, list.removeFirst());
        assertEquals(5, list.removeFirst());
        assertEquals(8, list.removeFirst());
    }

    @Test
    void testInsertionSort() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(5);
        list.append(3);
        list.append(8);
        list.append(1);
        list.append(2);

        list.insertionSort();

        assertEquals(1, list.removeFirst());
        assertEquals(2, list.removeFirst());
        assertEquals(3, list.removeFirst());
        assertEquals(5, list.removeFirst());
        assertEquals(8, list.removeFirst());
    }

    @Test
    void testMergeAlreadySorted() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(3);
        list.append(6);

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        list2.append(2);
        list2.append(5);
        list2.append(10);

        list.merge(list2);

        assertEquals(1, list.removeFirst());
        assertEquals(2, list.removeFirst());
        assertEquals(3, list.removeFirst());
        assertEquals(5, list.removeFirst());
        assertEquals(6, list.removeFirst());
        assertEquals(10, list.removeFirst());
    }
}