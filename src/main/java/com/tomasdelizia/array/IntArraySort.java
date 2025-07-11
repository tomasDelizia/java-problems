package com.tomasdelizia.array;

public class IntArraySort {
    /**
     * Sorts an array of integers using the bubble sort algorithm. Also known as direct swap sort.
     * Time complexity is O(n^2) in the worst case.
     * Space complexity is O(1) as it sorts the array in place.
     *
     * @param nums the array of integers to be sorted
     */
    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        // Loop through the array n-1 times because the last element will already be in place after n-1 iterations
        for (int i = 0; i < n - 1; i++) {
            boolean sorted = true;
            // Compare adjacent elements and swap them if they are in the wrong order
            // After each pass, the largest unsorted element is moved to its correct position
            // The inner loop runs n-i-1 times because the last i elements are already sorted
            for (int j = 0; j < n - i - 1; j++) {
                int current = nums[j];
                int next = nums[j + 1];
                if (current > next) {
                    sorted = false;
                    nums[j] = next;
                    nums[j + 1] = current;
                }
            }
            // If no swaps were made, the array is already sorted
            if (sorted) {
                break;
            }
        }
    }

    /**
     * Sorts an array of integers using the selection sort algorithm.
     * Selection sort is a simple comparison-based sorting algorithm that divides the input into a sorted and an unsorted region.
     * Time complexity is O(n^2) in the worst case.
     * Space complexity is O(1) as it sorts the array in place.
     *
     * @param nums the array of integers to be sorted
     */
    public static void selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    continue;
                }
                int larger = nums[i];
                nums[i] = nums[j];
                nums[j] = larger;
            }
        }
    }

    /**
     * Sorts an array of integers using the insertion sort algorithm.
     * Time complexity is O(n^2) in the worst case.
     * Space complexity is O(1) as it sorts the array in place.
     *
     * @param nums the array of integers to be sorted
     */
    public static void insertionSort(int[] nums, int increment, SortOrder order) {
        int n = nums.length;
        // Loop through the array starting from the second element
        for (int j = 1; j < n; j++) {
            // Store the current element to be inserted into the sorted part of the array
            int current = nums[j];
            // Find the correct position for the current element in the sorted part of the array
            int lastFromSorted = j - increment;
            // Shift elements in the sorted part of the array to the right until the correct position for the current element is found
            switch (order) {
                case ASCENDING:
                    while (lastFromSorted >= 0 && current < nums[lastFromSorted]) {
                        // Move the larger element h positions to the right
                        nums[lastFromSorted + increment] = nums[lastFromSorted];
                        // Move to the next element in the sorted part of the array
                        lastFromSorted -= increment;
                    }
                    break;
                case DESCENDING:
                    while (lastFromSorted >= 0 && current > nums[lastFromSorted]) {
                        // Move the larger element h positions to the right
                        nums[lastFromSorted + increment] = nums[lastFromSorted];
                        // Move to the next element in the sorted part of the array
                        lastFromSorted -= increment;
                    }
                    break;
            }
            // Insert the current element into its correct position in the sorted part of the array
            nums[lastFromSorted + increment] = current;
        }
    }

    /**
     * Sorts an array of integers using the shell sort algorithm.
     * Shell sort is an optimization of insertion sort that allows the exchange of items that are far apart.
     * Time complexity is O(n^2) in the worst case, but can be improved to O(n log n) with a good increment sequence.
     * Space complexity is O(1) as it sorts the array in place.
     *
     * @param nums the array of integers to be sorted
     */
    public static void shellSort(int[] nums, SortOrder order) {
        int n = nums.length, increment = 1;
        // Calculate the initial increment using the Knuth sequence
        // The increment is calculated as 3^k - 1 / 2, where k is the largest integer such that the increment is less than or equal to n/9
        while (increment <= n / 9) {
            increment = 3 * increment + 1;
        }
        while (increment > 0) {
            insertionSort(nums, increment, order);
            // Reduce the increment using the Knuth sequence
            increment /= 3;
        }
    }

    /**
     * Sorts an array of integers using the heap sort algorithm.
     * Heap sort is a comparison-based sorting algorithm that uses a binary heap data structure.
     * Time complexity is O(n log n) in the worst case.
     * Space complexity is O(1) as it sorts the array in place.
     *
     * @param nums the array of integers to be sorted
     */
    public static void heapSort(int[] nums) {
        int heapSize = nums.length;
        // Initial group
        for (int i = 0; i < heapSize; i++) {
            // Group the elements into a binary tree, where the parent node is greater than its children
            int valueToInsert = nums[i];
            int currentIndex = i;
            int parentIndex = (currentIndex - 1) / 2;
            while (currentIndex > 0 && nums[parentIndex] < valueToInsert) {
                nums[currentIndex] = nums[parentIndex];
                currentIndex = parentIndex;
                parentIndex = (currentIndex - 1) / 2;
            }
            nums[currentIndex] = valueToInsert;
        }
        // Extract root, reorder array and group
        for (int end = heapSize - 1; end > 0; end--) {
            // Swap the root of the heap with the last element in the unsorted part of the array
            int valueToReheap = nums[end];
            nums[end] = nums[0];
            int parentIndex = 0;
            int childIndex = (end == 1) ? -1 : 1;
            if (end > 2 && nums[2] > nums[1]) {
                childIndex = 2; // Start with the larger child
            }
            while (childIndex >= 0 && valueToReheap < nums[childIndex]) {
                nums[parentIndex] = nums[childIndex];
                parentIndex = childIndex;
                childIndex = 2 * parentIndex + 1;
                if (childIndex + 1 <= end - 1 && nums[childIndex] < nums[childIndex + 1]) {
                    childIndex++; // Choose the larger child
                }
                if (childIndex > end - 1) {
                    childIndex = -1; // No children left to compare
                }
            }
            nums[parentIndex] = valueToReheap;
        }
    }

    /**
     * Sorts an array of integers using the merge sort algorithm.
     * Merge sort is a divide-and-conquer algorithm that divides the array into halves, sorts each half, and merges them back together.
     * Time complexity is O(n log n).
     * Space complexity is O(n) due to the temporary arrays used for merging.
     *
     * @param nums the array of integers to be sorted
     */
    public static void mergeSort(int[] nums) {
        int n = nums.length;
        int[] temporary = new int[n];
        mergeSort(0, n - 1, nums, temporary);
    }

    private static void mergeSort(int left, int right, int[] nums, int[] temp) {
        if (left >= right) {
            return;
        }
        int center = (left + right) / 2;
        mergeSort(left, center, nums, temp);
        mergeSort(center + 1, right, nums, temp);
        merge(left, center, right, nums, temp);
    }

    private static void merge(int left, int center, int right, int[] nums, int[] temp) {
        int length = right - left + 1;
        if (length >= 0) {
            System.arraycopy(nums, left, temp, left, length);
        }
        int i = left, j = center + 1, k = left;
        while (i <= center && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= center) {
            nums[k] = temp[i];
            k++;
            i++;
        }
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, SortOrder.ASCENDING);
    }

    /**
     * Sorts an array of integers using the quick sort algorithm.
     * Quick sort is a divide-and-conquer algorithm that selects a pivot element and partitions the surrounding array.
     * Time complexity is O(n log n) on average, but can degrade to O(n^2) in the worst case.
     * Space complexity is O(log n) due to the recursive stack space.
     *
     * @param nums the array of integers to be sorted
     */
    public static void quickSort(int[] nums, SortOrder order) {
        if (nums == null || nums.length <= 1) {
            return; // No need to sort an empty array or an array with one element
        }
        quick(nums, 0, nums.length - 1, order);
    }

    private static void quick(int[] nums, int left, int right, SortOrder order) {
        int pivot = getPivotM3(nums, left, right);
        int i = left, j = right;
        // Pivot current subarray
        while (i <= j) {
            switch (order) {
                case ASCENDING:
                    while (nums[i] < pivot && i < right) {
                        i++;
                    }
                    while (pivot < nums[j] && j > left) {
                        j--;
                    }
                    if (i <= j) {
                        // Swap elements that are higher than pivot to the right and viceversa
                        swap(nums, i, j);
                        i++;
                        j--;
                    }
                    break;
                case DESCENDING:
                    while (nums[i] > pivot && i < right) {
                        i++;
                    }
                    while (pivot > nums[j] && j > left) {
                        j--;
                    }
                    if (i <= j) {
                        // Swap elements that are higher than pivot to the left and viceversa
                        swap(nums, i, j);
                        i++;
                        j--;
                    }
                    break;
            }

        }
        if (left < j) {
            // Pivot left half of array
            quick(nums, left, j, order);
        }
        if (i < right) {
            // Pivot right half of array
            quick(nums, i, right, order);
        }
    }

    private static int getPivotM3(int[] nums, int left, int right) {
        // return nums[(left + right) / 2];
        int center = (left + right) / 2;
        if (nums[right] < nums[left]) {
            // Swap left and right if left is greater than right
            swap(nums, left, right);
        }
        if (nums[center] < nums[left]) {
            // Swap center and left if center is less than left
            swap(nums, left, center);
        }
        if (nums[center] > nums[right]) {
            // Swap center and right if center is greater than right
            swap(nums, center, right);
        }
        return nums[center]; // Return the median of the three values as the pivot
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);
        return swapIndex;
    }

    public static void quickSortAlt(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int n = nums.length;
        quick(nums, 0, n-1);
    }

    private static void quick(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quick(array, left, pivotIndex-1);
            quick(array, pivotIndex+1, right);
        }
    }
}
