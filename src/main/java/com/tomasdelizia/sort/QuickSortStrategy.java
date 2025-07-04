package com.tomasdelizia.sort;

public class QuickSortStrategy<T> extends BaseSortStrategy<T> {

    @Override
    public void sort(T[] values) {
        int n = values.length;
        if (n < 2) return;
        quick(values, 0, n - 1);
    }

    private void quick(T[] values, int left, int right) {
        T pivot = getPivotM3(values, left, right);
        int i = left, j = right;
        // Pivot current subarray
        while (i <= j) {
            while (compare(values[i], pivot) < 0 && i < right) i++;
            while (compare(pivot, values[j]) < 0 && j > left) j--;
            if (i <= j) {
                // Swap elements that are higher than pivot to the right and viceversa
                T largerThanPivot = values[i];
                T lowerThanPivot = values[j];
                values[i] = lowerThanPivot;
                values[j] = largerThanPivot;
                i++;
                j--;
            }
        }
        if (left < j) {
            // Pivot left half of array
            quick(values, left, j);
        }
        if (i < right) {
            // Pivot right half of array
            quick(values, i, right);
        }
    }

    private T getPivotM3(T[] values, int left, int right) {
        // return values[(left + right) / 2];
        int center = (left + right) / 2;
        if (compare(values[right], values[left]) < 0) {
            // Swap left and right if left is greater than right
            T larger = values[left];
            values[left] = values[right];
            values[right] = larger;
        }
        if (compare(values[center], values[left]) < 0) {
            // Swap center and left if center is less than left
            T larger = values[left];
            values[left] = values[center];
            values[center] = larger;
        }
        if (compare(values[center], values[right]) > 0) {
            // Swap center and right if center is greater than right
            T lower = values[right];
            values[right] = values[center];
            values[center] = lower;
        }
        return values[center]; // Return the median of the three values as the pivot
    }
}
