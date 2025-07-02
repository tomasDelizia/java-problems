package com.tomasdelizia.problem.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        Map<Integer, Boolean> seenAndDuplicate = new HashMap<>();
        for (Integer num : nums) {
            Boolean valueSeen = seenAndDuplicate.get(num);
            if (valueSeen == null) {
                seenAndDuplicate.put(num, false);
                continue;
            }
            if (!valueSeen) {
                duplicates.add(num);
                seenAndDuplicate.put(num, true);
            }
        }
        return duplicates;
    }
}
