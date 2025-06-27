package com.tomasdelizia.arrays;

public class ArrayTransform {
    /**
     * Merges two sorted arrays into one sorted array.
     *
     * @param nums1 the first sorted array
     * @param nums2 the second sorted array
     * @return a new sorted array containing all elements from nums1 and nums2
     */
    public static int[] mergeSorted(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] merged = new int[n + m];
        int i = 0, j = 0, k = 0;
        // Merge the two arrays until one of them is fully traversed
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                merged[k] = nums1[i];
                i++;
            } else {
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }
        // If there are remaining elements in nums1, copy them. Else, copy remaining elements from nums2.
        int pos = j;
        int[] remaining = nums2;
        if (i < n) {
            pos = i;
            remaining = nums1;
        }
        while (pos < remaining.length) {
            merged[k] = remaining[pos];
            pos++;
            k++;
        }
        return merged;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int[] nonDuplicates = new int[n];
        nonDuplicates[0] = nums[0];
        int k = 1;
        for (int i = 1; i < n; i++) {
            int current = nums[i];
            if (current == nonDuplicates[k-1]) continue;
            nonDuplicates[k] = current;
            nums[k] = current;
            k++;
        }
        return k;
    }
}
