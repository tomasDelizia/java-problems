package com.tomasdelizia.sort;

import java.util.*;

public class BubbleSortStrategy<T> extends BaseSortStrategy<T> {
    public BubbleSortStrategy(Comparator<T> comparator) {
        super(comparator);
    }

    public BubbleSortStrategy() {
        super();
    }

    @Override
    public void sort(T[] values) {
        int n = values.length;
        for (int i = 0; i < n; i++) {
            boolean sorted = true;
            for (int j = 0; j < n - i - 1; j++) {
                T current = values[j];
                T next = values[j + 1];
                int compare = compare(current, next);
                if (compare > 0) {
                    // Swap values
                    sorted = false;
                    values[j] = next;
                    values[j + 1] = current;
                }
            }
            if (sorted) break;
        }
    }
}
