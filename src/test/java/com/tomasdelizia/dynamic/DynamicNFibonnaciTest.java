package com.tomasdelizia.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicNFibonnaciTest {
    @Test
    void fibonacciTdOfZero() {
        assertEquals(1, DynamicNFibonnaci.fibonacciTd(0));
    }

    @Test
    void fibonacciTdOfOne() {
        assertEquals(1, DynamicNFibonnaci.fibonacciTd(1));
    }

    @Test
    void fibonacciTdOfTwo() {
        assertEquals(2, DynamicNFibonnaci.fibonacciTd(2));
    }

    @Test
    void fibonacciTdOfThree() {
        assertEquals(3, DynamicNFibonnaci.fibonacciTd(3));
    }

    @Test
    void fibonacciTdOfFour() {
        assertEquals(5, DynamicNFibonnaci.fibonacciTd(4));
    }

    @Test
    void fibonacciTdOfFive() {
        assertEquals(8, DynamicNFibonnaci.fibonacciTd(5));
    }

    @Test
    void fibonacciTdOfSix() {
        assertEquals(13, DynamicNFibonnaci.fibonacciTd(6));
    }

    @Test
    void fibonacciBuOfZero() {
        assertEquals(1, DynamicNFibonnaci.fibonacciTd(0));
    }

    @Test
    void fibonacciBuOfOne() {
        assertEquals(1, DynamicNFibonnaci.fibonacciBu(1));
    }

    @Test
    void fibonacciBuOfTwo() {
        assertEquals(2, DynamicNFibonnaci.fibonacciBu(2));
    }

    @Test
    void fibonacciBuOfThree() {
        assertEquals(3, DynamicNFibonnaci.fibonacciBu(3));
    }

    @Test
    void fibonacciBuOfFour() {
        assertEquals(5, DynamicNFibonnaci.fibonacciBu(4));
    }

    @Test
    void fibonacciBuOfFive() {
        assertEquals(8, DynamicNFibonnaci.fibonacciBu(5));
    }

    @Test
    void fibonacciBuOfSix() {
        assertEquals(13, DynamicNFibonnaci.fibonacciBu(6));
    }
}