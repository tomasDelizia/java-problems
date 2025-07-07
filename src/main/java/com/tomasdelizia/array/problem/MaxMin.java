package com.tomasdelizia.array.problem;

public class MaxMin {
    public static int[] maxMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        int min = nums[0], max = nums[0], n = nums.length;
        for (int i = 1; i < n; i++) {
            int current = nums[i];
            if (current > max) max = current;
            if (current < min) min = current;
        }
        return new int[]{max, min};
    }
}
