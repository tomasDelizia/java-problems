package com.tomasdelizia.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackTest {

    @Test
    void testPush() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.getHeight());
        assertEquals(3, stack.getTop());
        stack.printStack(); // Should print: 3 2 1
    }

    @Test
    void testPop() {
        Stack<Integer> stack = new Stack<>(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.getHeight());
        assertEquals(2, stack.getTop());
        stack.printStack(); // Should print: 2 1
    }
}