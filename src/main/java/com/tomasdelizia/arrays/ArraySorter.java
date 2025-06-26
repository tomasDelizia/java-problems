package com.tomasdelizia.arrays;

public class ArraySorter {
    /**
     * Sorts an array of integers using the bubble sort algorithm. Also known as direct swap sort.
     *
     * @param nums the array of integers to be sorted
     */
    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        // Loop through the array n-1 times because the last element will already be in place after n-1 iterations
        for (int i = 0; i < n - 1; i++) {
            boolean sorted = true;
            // Compare adjacent elements and swap them if they are in the wrong order
            // After each pass, the largest unsorted element is moved to its correct position
            // The inner loop runs n-i-1 times because the last i elements are already sorted
            for (int j = 0; j < n - i - 1; j++) {
                int current = nums[j];
                int next = nums[j + 1];
                if (current > next) {
                    sorted = false;
                    nums[j] = next;
                    nums[j + 1] = current;
                }
            }
            // If no swaps were made, the array is already sorted
            if (sorted) {
                break;
            }
        }
    }
}
