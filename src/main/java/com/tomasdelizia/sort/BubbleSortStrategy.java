package com.tomasdelizia.sort;

import java.util.Comparator;

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
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                T current = values[j];
                T next = values[j + 1];
                int compare = compare(current, next);
                // Swap values
                if (compare > 0) {
                    values[j] = next;
                    values[j + 1] = current;
                }
            }
        }
    }
}
