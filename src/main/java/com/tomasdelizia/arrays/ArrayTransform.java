package com.tomasdelizia.arrays;

import static com.tomasdelizia.arrays.ArraySorter.quickSort;

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

    /**
     * Rotates the array to the right by k steps.
     *
     * @param nums the array to rotate
     * @param k    the number of steps to rotate
     */
    public static void rotate(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) return;
        int n = nums.length;
        // If k is greater than n, we only need to rotate by k % n steps
        k = k > n ? k % n : k;
        int[] firstKNums = new int[k];
        int ki = (k-1), j = n - 1;
        while (ki >= 0 && j >= 0) {
            firstKNums[ki] = nums[j];
            ki--;
            j--;
        }
        for (int i = n-k-1; i >= 0; i--) {
            nums[i+k] = nums[i];
        }
        System.arraycopy(firstKNums, 0, nums, 0, firstKNums.length);
    }

    /**
     * Finds the intersection of two arrays.
     * The result contains only unique elements that are present in both arrays.
     *
     * @param nums1 the first array
     * @param nums2 the second array
     * @return an array containing the intersection of nums1 and nums2
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        // Sort both arrays to ensure they are in ascending order
        quickSort(nums1, SortOrder.ASCENDING);
        quickSort(nums2, SortOrder.ASCENDING);
        int n = nums1.length, m = nums2.length;
        if (n == 0 || m == 0) return new int[0];
        int[] temporaryResult = new int[m+n];
        int k = 0;
        int j = 0;
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        for (int i = 0; i < min && j < max; i++) {
            int a = (n < m) ? nums1[i] : nums2[i];
            int b = (n < m) ? nums2[j] : nums1[j];
            if (a < b) continue;
            while (b < a && j < max - 1) {
                j++;
                b = (n < m) ? nums2[j] : nums1[j];
            }
            if (a != b) continue;
            temporaryResult[k] = a;
            j++;
            k++;
        }
        if (k == 0) return new int[0];
        int[] result = new int[k];
        System.arraycopy(temporaryResult, 0, result, 0, k);
        return result;
    }

    public static int[] intersectWithWhileLoop(int[] nums1, int[] nums2) {
        quickSort(nums1, SortOrder.ASCENDING);
        quickSort(nums2, SortOrder.ASCENDING);
        int n = nums1.length, m = nums2.length;
        int[] temp = new int[Math.min(n, m)];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                temp[k++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[k];
        System.arraycopy(temp, 0, result, 0, k);
        return result;
    }


}
