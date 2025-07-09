package com.tomasdelizia.stack.problem;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class SortStackTest {
    @Test
    void testSortStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        SortStack.sortStack(stack);
        assertEquals(1, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(4, stack.pop());
    }

}