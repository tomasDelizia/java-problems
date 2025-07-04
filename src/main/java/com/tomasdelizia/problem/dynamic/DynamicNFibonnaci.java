package com.tomasdelizia.problem.dynamic;

public class DynamicNFibonnaci {
    private static final int[] memo = new int[100];

    /**
     * Calculates the nth Fibonacci number using memoization.
     * Time complexity: O(2n-1) due to the linear growth of recursive calls with memoization
     * This is an example of top-down dynamic programming.
     * @param n the position in the Fibonacci sequence (0-indexed)
     * @return the nth Fibonacci number
     */
    public static int fibonacci(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }
        if (n <= 1) {
            return 1;
        }
        memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return memo[n];
    }
}
