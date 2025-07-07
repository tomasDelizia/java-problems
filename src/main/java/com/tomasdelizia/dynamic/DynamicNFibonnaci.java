package com.tomasdelizia.dynamic;

public class DynamicNFibonnaci {
    private static final int[] memo = new int[100];

    /**
     * Calculates the nth Fibonacci number using memoization.
     * Time complexity: O(2n-1) due to the linear growth of recursive calls with memoization
     * Leverages top-down dynamic programming.
     * @param n the position in the Fibonacci sequence (0-indexed)
     * @return the nth Fibonacci number
     */
    public static int fibonacciTd(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }
        if (n <= 1) {
            return 1;
        }
        memo[n] = fibonacciTd(n - 1) + fibonacciTd(n - 2);
        return memo[n];
    }

    /**
     * Calculates the nth Fibonacci number using memoization.
     * Time complexity: O(n) due to the linear growth of recursive calls with memoization
     * Leverages bottom-up dynamic programming. Equivalent to iterative approach.
     * @param n the position in the Fibonacci sequence (0-indexed)
     * @return the nth Fibonacci number
     */
    public static int fibonacciBu(int n) {
        int[] fibs = new int[n+1];
        fibs[0] = 1;
        fibs[1] =  1;
        for (int i = 2; i <= n; i++) {
            fibs[i] = fibs[i-1] + fibs[i-2];
        }
        return fibs[n];
    }
}
