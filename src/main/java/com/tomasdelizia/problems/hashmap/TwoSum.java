package com.tomasdelizia.problems.hashmap;


import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // Time: 1 for loop -> O(n)
    // Space: O(n)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexByValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int desiredValue = target - nums[i];
            if (indexByValue.containsKey(desiredValue)) {
                return new int[]{i, indexByValue.get(desiredValue)};
            }
            indexByValue.put(nums[i], i);
        }
        return null;
    }

}
