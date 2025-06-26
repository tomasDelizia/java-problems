package com.tomasdelizia.problems.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NFactorialTest {
    @Test
    void factorialOfZero() {
        assertEquals(1, NFactorial.factorial(0));
    }

    @Test
    void factorialOfOne() {
        assertEquals(1, NFactorial.factorial(1));
    }

    @Test
    void factorialOfBiggerThanOne() {
        assertEquals(2, NFactorial.factorial(2));
        assertEquals(6, NFactorial.factorial(3));
        assertEquals(24, NFactorial.factorial(4));
        assertEquals(120, NFactorial.factorial(5));
    }

}