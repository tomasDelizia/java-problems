package com.tomasdelizia.hash.problem;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    /**
     * Finds the first subarray in the array that sums to a given value.
     * @param nums the input array of integers
     * @param value the target sum value
     * @return an array containing the start and end indices of the subarray, or an empty array if no
     * such subarray exists
     */
    public static int[] subarraySum(int[] nums, int value) {
        int n = nums.length;
        if (n == 0) return new int[]{};
        // Stores the cumulative sum of the elements in the array as keys and indices as values.
        Map<Integer, Integer> indicesPerSum = new HashMap<>();
        // Put sum before first element of array.
        indicesPerSum.put(0, -1);
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            int current = nums[i];
            // Increment current sum.
            currentSum += current;
            int difference = currentSum - value;
            if (indicesPerSum.containsKey(difference)) {
                return new int[]{indicesPerSum.get(difference) + 1, i};
            }
            indicesPerSum.put(currentSum, i);
        }
        return new int[]{};
    }
}
