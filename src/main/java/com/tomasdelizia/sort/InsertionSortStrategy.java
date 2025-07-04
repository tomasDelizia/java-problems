package com.tomasdelizia.sort;

import java.util.Comparator;

public class InsertionSortStrategy<T> extends BaseSortStrategy<T> {
    public InsertionSortStrategy() {
        super();
    }

    public InsertionSortStrategy(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] values) {
        sort(values, 1);
    }

    public void sort(T[] values, int increment) {
        int n = values.length;
        // Loop through the array starting from the second element
        for (int j = 1; j < n; j++) {
            // Store the current element to be inserted into the sorted part of the array
            T current = values[j];
            // Find the correct position for the current element in the sorted part of the array
            int lastFromSorted = j - increment;
            // Shift elements in the sorted part of the array to the right until the correct position for the current element is found
            while (lastFromSorted >= 0 && compare(current, values[lastFromSorted]) < 0) {
                // Move the larger element h positions to the right
                values[lastFromSorted + increment] = values[lastFromSorted];
                // Move to the next element in the sorted part of the array
                lastFromSorted -= increment;
            }
            // Insert the current element into its correct position in the sorted part of the array
            values[lastFromSorted + increment] = current;
        }
    }
}
