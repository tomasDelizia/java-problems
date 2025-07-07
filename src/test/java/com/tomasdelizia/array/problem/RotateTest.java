package com.tomasdelizia.array.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateTest {
    @Test
    void testRotate() {
        int[] nums = {1};
        Rotate.rotate(nums, 1);
        assertArrayEquals(new int[]{1}, nums);

        nums = new int[]{1, 2};
        Rotate.rotate(nums, 3);
        assertArrayEquals(new int[]{2, 1}, nums);

        nums = new int[]{1, 2, 3};
        Rotate.rotate(nums, 4);
        assertArrayEquals(new int[]{3, 1, 2}, nums);

        nums = new int[]{1, 2};
        Rotate.rotate(nums, 5);
        assertArrayEquals(new int[]{2, 1}, nums);

        nums = new int[]{1, 2, 3, 4, 5};
        Rotate.rotate(nums, 2);
        assertArrayEquals(new int[]{4, 5, 1, 2, 3}, nums);

        nums = new int[]{1, 2, 3, 4, 5};
        Rotate.rotate(nums, 5);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, nums);

        nums = new int[]{1, 2, 3};
        Rotate.rotate(nums, 1);
        assertArrayEquals(new int[]{3, 1, 2}, nums);

        nums = new int[]{1, 2, 3, 4, 5};
        Rotate.rotate(nums, 3);
        assertArrayEquals(new int[]{3, 4, 5, 1, 2}, nums);
    }
}