package com.tomasdelizia.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeSortedLists {
    public static List<String> mergeSortedLists(List<List<String>> lists) {
        List<String> result = new ArrayList<>();
        Queue<Element> minHeap = new PriorityQueue<>();

        // Initialize the heap with the first element from each list
        for (int i = 0; i < lists.size(); i++) {
            List<String> list = lists.get(i);
            if (!list.isEmpty()) {
                minHeap.offer(new Element(list.getFirst(), i, 0));
            }
        }

        // Extract the minimum and add the next element from the same list
        while (!minHeap.isEmpty()) {
            Element current = minHeap.poll();
            result.add(current.value);

            int nextIndex = current.elementIndex + 1;
            List<String> currentList = lists.get(current.listIndex);
            if (nextIndex < currentList.size()) {
                Element next = new Element(currentList.get(nextIndex), current.listIndex, nextIndex);
                minHeap.offer(next);
            }
        }

        return result;
    }

    // Helper class to store value and its position in the list of lists
    private static class Element implements Comparable<Element> {
        String value;
        int listIndex;
        int elementIndex;

        Element(String value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }

        @Override
        public int compareTo(Element other) {
            return this.value.compareTo(other.value);
        }
    }
}
