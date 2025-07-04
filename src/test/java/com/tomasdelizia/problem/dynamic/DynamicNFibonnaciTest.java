package com.tomasdelizia.problem.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicNFibonnaciTest {
    @Test
    void fibonacciOfZero() {
        assertEquals(1, DynamicNFibonnaci.fibonacci(0));
    }

    @Test
    void fibonacciOfOne() {
        assertEquals(1, DynamicNFibonnaci.fibonacci(1));
    }

    @Test
    void fibonacciOfTwo() {
        assertEquals(2, DynamicNFibonnaci.fibonacci(2));
    }

    @Test
    void fibonacciOfThree() {
        assertEquals(3, DynamicNFibonnaci.fibonacci(3));
    }

    @Test
    void fibonacciOfFour() {
        assertEquals(5, DynamicNFibonnaci.fibonacci(4));
    }

    @Test
    void fibonacciOfFive() {
        assertEquals(8, DynamicNFibonnaci.fibonacci(5));
    }

    @Test
    void fibonacciOfSix() {
        assertEquals(13, DynamicNFibonnaci.fibonacci(6));
    }
}