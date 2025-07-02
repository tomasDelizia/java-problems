package com.tomasdelizia.problem.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthSmallestValue {
    public static int findKthSmallestValue(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (Integer num : nums) {
            maxHeap.offer(num);
            // Check if the number of elements in the heap is smaller than k
            if (maxHeap.size() > k) {
                // Remove the top element so that the heap only contains k elements
                maxHeap.poll();
            }
        }
        if (maxHeap.isEmpty()) {
            return -1;
        }
        return maxHeap.poll();
    }
}
