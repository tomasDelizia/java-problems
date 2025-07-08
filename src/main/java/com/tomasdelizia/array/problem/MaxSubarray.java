package com.tomasdelizia.array.problem;

public class MaxSubarray {
    /**
     * Finds the maximum subarray sum using Kadane's algorithm.
     *
     * @param nums the input array of integers
     * @return the maximum subarray sum
     */
    public static int maxSubarray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int maxSum = nums[0], currentSum = nums[0];
        for (int i = 1; i < n; i++) {
            int current = nums[i];
            // Decide whether to start a new subarray or to include current.
            currentSum = Math.max(current, currentSum + current);
            // Ensures maxSum stores the maximum subarray sum seen so far.
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
