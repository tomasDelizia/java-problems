package com.tomasdelizia.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinStackTest {
    @Test
    void testPush() {
        MinStack<Integer> stack = new MinStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.getHeight());
        assertEquals(3, stack.getTop());
        stack.printStack(); // Should print: 3 2 1
    }

    @Test
    void testPop() {
        MinStack<Integer> stack = new MinStack<>(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(1, stack.getMinValue());
        assertEquals(2, stack.getHeight());
        assertEquals(2, stack.getTop());
        stack.printStack(); // Should print: 2 1
    }

    @Test
    void testGetMinValue() {
        MinStack<Integer> stack = new MinStack<>();
        stack.push(3);
        stack.push(1);
        stack.push(2);
        assertEquals(1, stack.getMinValue());
        stack.pop();
        assertEquals(1, stack.getMinValue());
        stack.pop();
        assertEquals(3, stack.getMinValue());
    }
}
