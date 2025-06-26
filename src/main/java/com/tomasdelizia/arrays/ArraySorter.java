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

    /**
     * Sorts an array of integers using the insertion sort algorithm.
     *
     * @param nums the array of integers to be sorted
     */
    public static void insertionSort(int[] nums, int increment) {
        int n = nums.length;
        // Loop through the array starting from the second element
        for (int j = 1; j < n; j++) {
            // Store the current element to be inserted into the sorted part of the array
            int current = nums[j];
            // Find the correct position for the current element in the sorted part of the array
            int lastFromSorted = j - increment;
            // Shift elements in the sorted part of the array to the right until the correct position for the current element is found
            while (lastFromSorted >= 0 && current < nums[lastFromSorted]) {
                // Move the larger element h positions to the right
                nums[lastFromSorted + increment] = nums[lastFromSorted];
                // Move to the next element in the sorted part of the array
                lastFromSorted -= increment;
            }
            // Insert the current element into its correct position in the sorted part of the array
            nums[lastFromSorted + increment] = current;
        }
    }

    /**
     * Sorts an array of integers using the shell sort algorithm.
     * Shell sort is an optimization of insertion sort that allows the exchange of items that are far apart.
     *
     * @param nums the array of integers to be sorted
     */
    public static void shellSort(int[] nums) {
        int n = nums.length, increment = 1;
        // Calculate the initial increment using the Knuth sequence
        // The increment is calculated as 3^k - 1 / 2, where k is the largest integer such that the increment is less than or equal to n/9
        while (increment <= n / 9) {
            increment = 3 * increment + 1;
        }
        while (increment > 0) {
            insertionSort(nums, increment);
            // Reduce the increment using the Knuth sequence
            increment /= 3;
        }
    }
}
