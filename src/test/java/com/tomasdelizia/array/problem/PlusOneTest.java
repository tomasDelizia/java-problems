package com.tomasdelizia.array.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PlusOneTest {
    @Test
    void plusOneTest() {
        int[] digits1 = {7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6};
        int[] result1 = PlusOne.plusOne(digits1);
        assertArrayEquals(new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 7}, result1);
    }

    @Test
    void plusOneWithBigIntTest() {
        int[] digits1 = {1, 2, 3};
        int[] result1 = PlusOne.plusOneWithBigInt(digits1);
        assertArrayEquals(new int[]{1, 2, 4}, result1);

        int[] digits2 = {4, 3, 2, 1};
        int[] result2 = PlusOne.plusOneWithBigInt(digits2);
        assertArrayEquals(new int[]{4, 3, 2, 2}, result2);

        int[] digits3 = {9, 9, 9};
        int[] result3 = PlusOne.plusOneWithBigInt(digits3);
        assertArrayEquals(new int[]{1, 0, 0, 0}, result3);

        int[] digits4 = {0};
        int[] result4 = PlusOne.plusOneWithBigInt(digits4);
        assertArrayEquals(new int[]{1}, result4);

        int[] digits5 = {1};
        int[] result5 = PlusOne.plusOneWithBigInt(digits5);
        assertArrayEquals(new int[]{2}, result5);

        int[] digits10 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] result10 = PlusOne.plusOneWithBigInt(digits10);
        assertArrayEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1}, result10);
    }

}