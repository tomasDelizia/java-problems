package com.tomasdelizia.array.problem;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int writeIndex = 1, n = nums.length;
        if (n <= 1) return n;
        for (int i = 1; i < n; i++) {
            int current = nums[i];
            int last = nums[i-1];
            if (current == last) continue;
            nums[writeIndex] = current;
            writeIndex++;
        }
        return writeIndex;
    }
}
