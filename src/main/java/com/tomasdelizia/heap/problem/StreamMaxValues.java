package com.tomasdelizia.heap.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class StreamMaxValues {
    public static List<Integer> streamMaxValues(int[] nums) {
        List<Integer> maxValues = new ArrayList<>();
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (Integer num : nums) {
            maxHeap.offer(num);
            maxValues.add(maxHeap.peek());
        }
        return maxValues;
    }
}
