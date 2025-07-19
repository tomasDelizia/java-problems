package com.tomasdelizia.hash.problem;

import java.util.*;

public class TopKFrequentElements {
    /**
     * Finds the k most frequent elements in an array using a min heap.
     * Time Complexity: O(n log k), where n is the number of elements in the input array.
     * Space Complexity: O(n), where n is the number of unique elements in the input array.
     *
     * @param nums the input array of integers
     * @param k    the number of top frequent elements to return
     * @return an array containing the k most frequent elements
     */
    public static int[] topKFrequentMinHeap(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> frequencies = getFrequencies(nums);

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

    /**
     * Finds the k most frequent elements in an array using bucket sort.
     * Time Complexity: O(n), where n is the number of elements in the input array.
     * Space Complexity: O(n), where n is the number of unique elements in the input array.
     *
     * @param nums the input array of integers
     * @param k    the number of top frequent elements to return
     * @return an array containing the k most frequent elements
     */
    public static int[] topKFrequentBucketSort(int[] nums, int k) {
        Map<Integer, Integer> frequencies = getFrequencies(nums);
        int n = nums.length;
        int maxCount = 0;
        List<List<Integer>> bucket = new ArrayList<>();
        // The bucket will have at most n elements, which is the max amount of times a value can appear in the array.
        for (int i = 0; i <= n; i++) bucket.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry: frequencies.entrySet()) {
            Integer number = entry.getKey(), count = entry.getValue();
            bucket.get(count).add(number);
            maxCount = Math.max(maxCount, count);
        }
        List<Integer> result = new ArrayList<>(k);
        // Start adding the values from maxCount, since everything after that will be an empty list.
        for (int i = maxCount; i >= 1; i--) {
            List<Integer> valuesPerCount = bucket.get(i);
            if (valuesPerCount.isEmpty()) continue;
            for (Integer value : valuesPerCount) {
                result.add(value);
                if (result.size() == k) break;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static Map<Integer, Integer> getFrequencies(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        // Store the frequencies for each value in the array.
        for (int current : nums) {
            if (frequencies.containsKey(current)) {
                frequencies.put(current, frequencies.get(current) + 1);
                continue;
            }
            frequencies.put(current, 1);
        }
        return frequencies;
    }
}
