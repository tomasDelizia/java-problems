package com.tomasdelizia.sort;

import java.util.Arrays;

public class MergeSortStrategy<T> extends BaseSortStrategy<T> {
    @SuppressWarnings("unchecked")
    private T[] merge(T[] a, T[] b) {
        int n = a.length, m = b.length;
        T[] merged = (T[]) new Object[n+m];
        int i = 0, j = 0, k = 0;
        // Merge the two arrays until one of them is fully traversed
        while (i < n && j < m) {
            int compare = compare(a[i], b[j]);
            if (compare < 0) {
                merged[k] = a[i];
                i++;
            } else {
                merged[k] = b[j];
                j++;
            }
            k++;
        }
        // If there are remaining elements in a, copy them. Else, copy remaining elements from b.
        int pos = j;
        T[] remaining = b;
        if (i < n) {
            pos = i;
            remaining = a;
        }
        while (pos < remaining.length) {
            merged[k] = remaining[pos];
            pos++;
            k++;
        }
        return merged;
    }

    private T[] mergeSort(T[] values) {
        // Recursive base: An array of length 1 is sorted
        if (values.length == 1) return values;

        int n = values.length;
        int center = n / 2;
        // Run mergeSort recursively until all subarrays are sorted.
        T[] left = mergeSort(Arrays.copyOfRange(values, 0, center));
        T[] right = mergeSort(Arrays.copyOfRange(values, center, n));
        // Run merge to merge two already sorted arrays into one.
        return merge(left, right);
    }

    @Override
    public void sort(T[] values) {
        int n = values.length;
        T[] sorted = mergeSort(values);
        System.arraycopy(sorted, 0, values, 0, n);
    }
}
