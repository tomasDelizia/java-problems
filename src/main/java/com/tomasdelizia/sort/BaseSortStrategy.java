package com.tomasdelizia.sort;

import java.util.Comparator;

public abstract class BaseSortStrategy<T> implements Sorter<T> {
    private final Comparator<T> comparator;

    protected BaseSortStrategy(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    protected BaseSortStrategy() {
        this.comparator = null;
    }

    @SuppressWarnings("unchecked")
    protected int compare(Object k1, Object k2) {
        return (comparator != null) ? comparator.compare((T) k1, (T) k2)
                : ((Comparable<? super T>) k1).compareTo((T) k2);
    }
}
