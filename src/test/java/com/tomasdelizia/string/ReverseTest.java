package com.tomasdelizia.string;

import com.tomasdelizia.stack.problem.Reverse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseTest {
    @Test
    void testReverseWithStack() {
        assertEquals("olleh", Reverse.reverseWithStack("hello"));
        assertEquals("dlrow", Reverse.reverseWithStack("world"));
        assertEquals("", Reverse.reverseWithStack(""));
        assertEquals("a", Reverse.reverseWithStack("a"));
        assertEquals("12345", Reverse.reverseWithStack("54321"));
    }

}