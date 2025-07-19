package com.tomasdelizia.hash.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> frequencies = new HashMap<>();
        // Store the frequencies for each value in the array.
        for (int current : nums) {
            if (frequencies.containsKey(current)) {
                frequencies.put(current, frequencies.get(current) + 1);
                continue;
            }
            frequencies.put(current, 1);
        }

        // Create a min heap that stores the k most frequent elements.
        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Map.Entry.comparingByValue());
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        for (int i = 0; !minHeap.isEmpty(); i++) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}
