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

    @Override
    public void sort(List<T> values) {
        boolean sorted;
        do {
            sorted = true;
            ListIterator<T> it = values.listIterator();
            if (!it.hasNext()) break;

            T prev = it.next();
            while (it.hasNext()) {
                T curr = it.next();
                if (compare(prev, curr) > 0) {
                    // Swap elements
                    it.set(prev); // set current to prev
                    it.previous(); // move back to prev
                    it.previous(); // move to position before prev
                    it.set(curr);  // set prev to curr
                    it.next();     // move forward to re-align
                    it.next();

                    sorted = false;
                } else prev = curr;
            }
        } while (!sorted);
    }
}
