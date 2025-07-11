package com.tomasdelizia.matrix.problem;

public class RotateMatrix {
    /**
     * Rotates a square matrix 90 degrees clockwise in place.
     * @param matrix the square matrix to be rotated
     */
    public static void rotateSquareMatrix(int[][] matrix) {
        int n = matrix.length;
        int left = 0, right = n - 1;
        // When left < right, there's no more array to traverse.
        while (left < right) {
            int swaps = right - left;
            // The for rotates one layer at the time, starting from the outer layer.
            for (int i = 0; i < swaps; i++) {
                // Top and bottom are equal to left and right because it's a square matrix.
                int top = left, bottom = right;
                // Save top left+i value
                int topLeft = matrix[top][left + i];
                // Move bottom-i left to top+i left.
                matrix[top][left + i] = matrix[bottom - i][left];
                // Move bottom right-i to bottom-i left.
                matrix[bottom - i][left] = matrix[bottom][right - i];
                // Move top+i right to bottom right-i
                matrix[bottom][right - i] = matrix[top + i][right];
                // Mov top left+i to top+i right.
                matrix[top + i][right] = topLeft;
            }
            // Update pointers to rotate an inner layer.
            right--;
            left++;
        }
    }
}
