package com.tomasdelizia.matrix;

public class SquareMatrixUtils {
    public static int[][] multiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    /**
     * Counts the number of zeroes in the main diagonal of a square matrix.
     *
     * @param mat the square matrix to check
     * @return the count of zeroes in the main diagonal
     */
    public static int countZeroesInMainDiagonal(int[][] mat) {
        int counter = 0, n = mat.length;
        for (int r = 0; r < n; r++) {
            if (mat[r][r] == 0) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Sums the number of elements in the upper triangle of a square matrix.
     *
     * @param mat the square matrix to check
     * @return the count of elements in the upper triangle
     */
    public static int sumUpperTriangle(int[][] mat) {
        int counter = 0, n = mat.length;
        // Iterate through the upper triangle excluding the main diagonal
        // r starts from 0 to n-1, because the last row does not have any upper triangle elements
        for (int r = 0; r < n - 1; r++) {
            // c starts from r + 1 to n, because r is the current row and we want to count elements to the right of the main diagonal
            for (int c = r + 1; c < n; c++) {
                counter += mat[r][c];
            }
        }
        return counter;
    }

    public static int sumInLowerTriangle(int[][] mat) {
        int counter = 0, n = mat.length;
        // Iterate through the lower triangle excluding the main diagonal
        // r starts from 1 to n-1, because the first row does not have any lower triangle elements
        for (int r = 1; r < n; r++) {
            // c starts from 0 to r, because r is the current row and we want to count elements to the left of the main diagonal
            for (int c = 0; c < r; c++) {
                counter += mat[r][c];
            }
        }
        return counter;
    }


}
