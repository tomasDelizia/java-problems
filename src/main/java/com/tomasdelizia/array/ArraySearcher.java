package com.tomasdelizia.array;

public class ArraySearcher {

    /**
     * Performs a binary search on a sorted array to find the index of a given value.
     *
     * @param nums  the sorted array to search in
     * @param value the value to search for
     * @return the index of the value if found, otherwise -1
     */
    public static int binarySearch(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // Calculate the middle index and the value at that index
            int c = left + (right - left) / 2, valueAtCenter = nums[c];
            // Check if the value at the center is equal to the target value
            if (value == valueAtCenter) {
                return c;
            }
            // If the value at the center is less than the target value, define the new left boundary
            if (value < valueAtCenter) {
                right = c - 1;
            }
            // If the value at the center is greater than the target value, define the new right boundary
            else {
                left = c + 1;
            }
        }
        return -1;
    }
}
