package com.tomasdelizia.hash.problem;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        // Removes duplicates by using a set.
        for (Integer num : nums) numSet.add(num);

        int maxSequence = 0;
        for (Integer num : numSet) {
            int prev = num - 1;
            if (numSet.contains(prev)) continue;
            // If it doesn't contain num - 1, it's the start of a new consecutive sequence.
            int current = num;
            int currentSequence = 1;
            while (numSet.contains(current + 1)) {
                // Increment the sequence by one if it contains the next element in the sequence.
                current++;
                currentSequence++;
            }
            // Update max sequence accordingly.
            maxSequence = Math.max(currentSequence, maxSequence);
        }
        return maxSequence;
    }
}
