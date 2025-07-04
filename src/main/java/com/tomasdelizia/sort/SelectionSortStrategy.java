package com.tomasdelizia.sort;

public class SelectionSortStrategy<T> extends BaseSortStrategy<T> {
    public SelectionSortStrategy() {
        super();
    }

    @Override
    public void sort(T[] values) {
        int n = values.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int compare = compare(values[i], values[j]);
                if (compare < 0) {
                    continue;
                }
                T larger = values[i];
                values[i] = values[j];
                values[j] = larger;
            }
        }
    }
}
