package com.tomasdelizia.array.problem;

public class Rotate {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return;
        int steps = k % n;
        // Reverse first part
        swap(nums, 0, n - steps - 1);
        // Reverse second part
        swap(nums, n - steps, n - 1);
        // Swap the whole array
        swap(nums, 0, n - 1);
    }

    private static void swap(int[] nums, int start, int end) {
        // Equivalent loop
        /*
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        } */
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
