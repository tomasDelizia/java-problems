package com.tomasdelizia.sort;

import java.util.List;

public interface Sorter<T> {
    void sort(T[] values);
    void sort(List<T> values);
}
