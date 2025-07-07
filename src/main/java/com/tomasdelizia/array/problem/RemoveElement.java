package com.tomasdelizia.array.problem;

public class RemoveElement {
    /**
     * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
     * @param nums Array of integers
     * @param value Value to remove from the array
     * @return The new length of the array after removing the specified value
     */
    public static int removeElement(int[] nums, int value) {
        //insertionSort(nums);
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            int current = nums[i];
            if (current == value) continue;
            nums[index] = current;
            index++;
        }
        return index;
    }
}
