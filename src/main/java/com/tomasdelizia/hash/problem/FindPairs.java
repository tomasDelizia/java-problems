package com.tomasdelizia.hash.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPairs {
    public static List<int[]> findPairs(int[] nums1, int[] nums2, int value) {
        Set<Integer> nums1Set = new HashSet<>();
        List<int[]> result = new ArrayList<>();
        for (Integer num : nums1) nums1Set.add(num);
        for (Integer num : nums2) {
            int difference = value - num;
            if (nums1Set.contains(difference)) result.add(new int[]{difference, num});
        }
        return result;
    }
}
