package com.tomasdelizia.hash.problem;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        Set<Integer> valuesSeenOnce = new HashSet<>();
        valuesSeenOnce.add(nums[0]);
        for (int i = 1; i < n; i++) {
            int current = nums[i];
            if (valuesSeenOnce.contains(current)) {
                valuesSeenOnce.remove(current);
                continue;
            }
            valuesSeenOnce.add(current);
        }
        return valuesSeenOnce.stream().findFirst().orElse(-1);
    }

    public static int singleNumberXor(int[] nums) {
        int n = nums.length;
        int result = nums[0];
        if (n == 1) return result;
        for (int i = 1; i < n; i++) {
            int current = nums[i];
            // Example of bitwise XOR operation: // 5 ^ 5 = 0, 5 ^ 0 = 5, 1 ^ 3 = 2
            result ^= current; // XOR each number, meaning if a number appears twice, it cancels itself out
        }
        return result; // The unique number remains
    }
}
