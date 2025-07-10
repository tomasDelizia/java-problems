package com.tomasdelizia.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    @Test
    void testLinkedList() {
        // Test creating a linked list with a single element
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(5);
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
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
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
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
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
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
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
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
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
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
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
        DoublyLinkedList<Integer> emptyList = new DoublyLinkedList<>();
        emptyList.reverse();
        assertNull(emptyList.getValue(0)); // Should still be empty
    }

    @Test
    void testIsPalindrome() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        assertFalse(list.isPalindrome()); // Not a palindrome

        DoublyLinkedList<Integer> palindromeList = new DoublyLinkedList<>();
        palindromeList.append(1);
        palindromeList.append(2);
        palindromeList.append(1);
        assertTrue(palindromeList.isPalindrome()); // Is a palindrome

        DoublyLinkedList<Integer> evenPalindromeList = new DoublyLinkedList<>();
        evenPalindromeList.append(1);
        evenPalindromeList.append(2);
        evenPalindromeList.append(2);
        evenPalindromeList.append(1);
        assertTrue(evenPalindromeList.isPalindrome()); // Is a palindrome

        DoublyLinkedList<Integer> emptyList = new DoublyLinkedList<>();
        assertTrue(emptyList.isPalindrome()); // Empty list is considered a palindrome
    }

    @Test
    void testPartition() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(3);
        list.append(5);
        list.append(8);
        list.append(5);
        list.append(10);
        list.append(2);
        list.append(1);

        System.out.println("Original list:");
        list.printList();

        list.partition(5);
        System.out.println("Partitioned list around 5:");
        list.printList();

        // Check if the partitioning is correct
        assertTrue(list.getValue(0) <= 5);
        assertTrue(list.getValue(list.size() - 1) >= 5);
    }

    @Test
    void testReverseBetween() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        System.out.println("Original list:");
        list.printList();

        // Reverse between indices 1 and 3 (inclusive)
        list.reverseBetween(1, 3);
        System.out.println("List after reversing between indices 1 and 3:");
        list.printList();

        assertEquals(1, list.getValue(0));
        assertEquals(4, list.getValue(1));
        assertEquals(3, list.getValue(2));
        assertEquals(2, list.getValue(3));
        assertEquals(5, list.getValue(4));
    }

    @Test
    void testSwapPairs() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        System.out.println("Original list:");
        list.printList();

        // Swap pairs
        list.swapPairs();
        System.out.println("List after swapping pairs:");
        list.printList();

        assertEquals(2, list.getValue(0));
        assertEquals(1, list.getValue(1));
        assertEquals(4, list.getValue(2));
        assertEquals(3, list.getValue(3));
    }
}