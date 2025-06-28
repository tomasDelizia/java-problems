package com.tomasdelizia.problems.hashmap;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {
    public static boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        if (n <= 1) return false;
        Set<Integer> seenValues = new HashSet<>();
        seenValues.add(nums[0]);
        for (int i = 1; i < n; i++) {
            int current = nums[i];
            if (seenValues.contains(current)) return true;
            seenValues.add(current);
        }
        return false;
    }
}
