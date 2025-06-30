package com.tomasdelizia.problem.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NFibonacciTest {
    @Test
    void fibonacciOfZero() {
        assertEquals(1, NFibonacci.fibonacci(0));
    }

    @Test
    void fibonacciOfOne() {
        assertEquals(1, NFibonacci.fibonacci(1));
    }

    @Test
    void fibonacciOfTwo() {
        assertEquals(2, NFibonacci.fibonacci(2));
    }

    @Test
    void fibonacciOfThree() {
        assertEquals(3, NFibonacci.fibonacci(3));
    }

    @Test
    void fibonacciOfFour() {
        assertEquals(5, NFibonacci.fibonacci(4));
    }

    @Test
    void fibonacciOfFive() {
        assertEquals(8, NFibonacci.fibonacci(5));
    }

    @Test
    void fibonacciOfSix() {
        assertEquals(13, NFibonacci.fibonacci(6));
    }

    @Test
    void fibonacciWithForLoopOfZero() {
        assertEquals(1, NFibonacci.fibonacciWithForLoop(0));
    }

    @Test
    void fibonacciWithForLoopOfOne() {
        assertEquals(1, NFibonacci.fibonacciWithForLoop(1));
    }

    @Test
    void fibonacciWithForLoopOfTwo() {
        assertEquals(8, NFibonacci.fibonacciWithForLoop(5));
    }

}