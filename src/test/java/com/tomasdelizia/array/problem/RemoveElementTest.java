package com.tomasdelizia.array.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementTest {
    @Test
    void testRemoveElement() {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int expectedLength = 2;
        int[] expectedArray = {2, 2};

        int newLength = RemoveElement.removeElement(nums, val);
        assertEquals(expectedLength, newLength);

        for (int i = 0; i < newLength; i++) {
            assertEquals(expectedArray[i], nums[i]);
        }
    }

}