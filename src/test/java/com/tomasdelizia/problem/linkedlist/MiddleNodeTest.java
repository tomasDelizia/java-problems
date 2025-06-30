package com.tomasdelizia.problem.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MiddleNodeTest {
    @Test
    void testFindMiddleValue() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Integer middleValue = MiddleNode.findMiddleValue(list);
        assertEquals(3, middleValue);

        list.clear();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        middleValue = MiddleNode.findMiddleValue(list);
        assertEquals(2, middleValue);

        list.clear();
        assertThrows(NoSuchElementException.class, () -> MiddleNode.findMiddleValue(list));

        list.add(1);
        middleValue = MiddleNode.findMiddleValue(list);
        assertEquals(1, middleValue);
    }
}