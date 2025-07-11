package com.tomasdelizia.array.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /**
     * Finds all unique triplets in the array that sum up to zero.
     * @param nums the input array of integers
     * @return a list of lists, where each inner list contains three integers that sum to zero
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        List<List<Integer>> result = new ArrayList<>();

        // Ensure the array is sorted to use two sum.
        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            // Avoid reusing the same value.
            if (i > 0 && a == nums[i-1]) continue;

            // Do two sum.
            int left = i + 1, right = n - 1;
            while (left < right) {
                int threeSum = a + nums[left] + nums[right];
                if (threeSum == target) {
                    List<Integer> triplet = List.of(a, nums[left], nums[right]);
                    if (!result.contains(triplet)) result.add(triplet);
                    // Update only one of the pointers. The other one will update itself.
                    do left++;
                    while (left < right && nums[left] == nums[left - 1]);
                }
                else if (threeSum > target) right--;
                else left++;
            }
        }
        return result;
    }
}
