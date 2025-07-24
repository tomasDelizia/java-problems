package com.tomasdelizia.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap<T> {
    private final List<T> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public Heap(T[] values) {
        buildHeap(values);
        this.heap = new ArrayList<>(List.of(values));
    }

    public List<T> getHeap() {
        // Returns a copy of the heap so that it cannot be modified externally
        return new ArrayList<>(heap);
    }

    public void insert(T value) {
        heap.add(value);
        int current = heap.size() - 1;
        int parent = parentIndex(current);
        // Loop from the bottom until the top is reached or until the current element is lower than its parent
        while (current > 0 && compare(heap.get(current), heap.get(parent)) > 0) {
            swap(current, parent);
            current = parent;
            parent = parentIndex(current);
        }
    }

    /**
     * Removes the root element from the heap and returns it.
     * The root is the maximum element in a max-heap.
     *
     * @return the removed root element, or null if the heap is empty
     */
    public T remove() {
        if (heap.isEmpty()) {
            return null;
        }
        if (heap.size() == 1) {
            return heap.removeFirst();
        }
        T maxValue = heap.getFirst();
        // Move the node from the bottom right (at address heap.size() - 1 ) to the top so that the heap remains complete
        T bottomRight = heap.removeLast();
        heap.set(0, bottomRight);
        // Loop from the top until the bottom is reached or until the current element is larger than its children
        sinkDown(0);
        return maxValue;
    }

    @SuppressWarnings("SameParameterValue")
    private void sinkDown(int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = leftChildIndex(index);
            int rightIndex = rightChildIndex(index);
            // If the left child is larger than the parent, we swap them. We also check if the parent has a right child
            if (leftIndex < heap.size() && compare(heap.get(leftIndex), heap.get(maxIndex)) > 0) {
                maxIndex = leftIndex;
            }
            // If the right child is larger than the parent, we swap them. We also check if the parent has a right child
            if (rightIndex < heap.size() && compare(heap.get(rightIndex), heap.get(maxIndex)) > 0) {
                maxIndex = rightIndex;
            }
            if (maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            }
            // If the values are equal, there's no need to sink lower
            else {
                return;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private int compare(Object k1, Object k2) {
        return ((Comparable<? super T>) k1).compareTo((T) k2);
    }

    /**
     * Calculates the index of the left child of a node in a binary heap.
     *
     * @param index the index of the node
     * @return the index of the left child
     */
    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    /**
     * Calculates the index of the right child of a node in a binary heap.
     *
     * @param index the index of the node
     * @return the index of the right child
     */
    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    /**
     * Calculates the index of the parent of a node in a binary heap.
     *
     * @param index the index of the node
     * @return the index of the parent
     */
    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    /**
     * Swaps two elements in the heap.
     *
     * @param index1 the index of the first element
     * @param index2 the index of the second element
     */
    private void swap(int index1, int index2) {
        T toSwap1 = heap.get(index1), toSwap2 = heap.get(index2);
        if (toSwap1 == null || toSwap2 == null) {
            return; // Cannot swap if either element is null
        }
        heap.set(index1, toSwap2);
        heap.set(index2, toSwap1);
    }

    private void heapify(T[] values, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && compare(values[left], values[largest]) > 0) largest = left;

        // If right child is larger than largest so far
        if (right < n && compare(values[right], values[largest]) > 0) largest = right;

        // If largest is not root
        if (largest != i) {
            T swap = values[i];
            values[i] = values[largest];
            values[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(values, n, largest);
        }
    }

    // Function to build a Max-Heap from the given array
    private void buildHeap(T[] values) {
        int n = values.length;
        // Index of last non-leaf node
        int startIdx = (n / 2) - 1;

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIdx; i >= 0; i--) {
            heapify(values, n, i);
        }
    }
}
