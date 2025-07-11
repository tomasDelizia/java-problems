package com.tomasdelizia.array.problem;

public class TwoSumPointers {
    /**
     * Finds two indices in a sorted array such that the numbers at those indices sum up to a target value.
     * @param nums the sorted array of integers
     * @param target the target sum to find
     * @return an array containing the two indices, or an empty array if no such indices exist
     */
    public static int[] twoSumWithPointersOnSorted(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) return new int[]{left, right};
            // Decreasing the right pointer decreases the sum.
            if (sum > target) right--;
            // Increasing the left pointer increases the sum.
            else left++;
        }
        return new int[]{};
    }
}
