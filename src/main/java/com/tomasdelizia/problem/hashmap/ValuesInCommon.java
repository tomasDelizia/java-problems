package com.tomasdelizia.problem.hashmap;

import java.util.HashSet;
import java.util.Set;

public class ValuesInCommon {
    public static boolean valuesInCommon(int[] nums1, int[] nums2) {
        Set<Integer> valuesInFirst = new HashSet<>();
        for (int i : nums1) {
            valuesInFirst.add(i);
        }
        for (int j : nums2) {
            if (valuesInFirst.contains(j)) {
                return true;
            }
        }
        return false;
    }
}
