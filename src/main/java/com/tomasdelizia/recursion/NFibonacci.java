package com.tomasdelizia.recursion;

public class NFibonacci {
    /**
     * Calculates the nth Fibonacci number recursively.
     * * Time complexity: O(2^n) due to the exponential growth of recursive calls
     *
     * @param n the position in the Fibonacci sequence (0-indexed)
     * @return the nth Fibonacci number
     */
    public static long fibonacci(long n) {
        if (n <= 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Calculates the nth Fibonacci number using a for loop.
     * Time complexity: O(n)
     *
     * @param n the position in the Fibonacci sequence (0-indexed)
     * @return the nth Fibonacci number
     */
    public static long fibonacciWithForLoop(long n) {
        if (n <= 1) {
            return 1;
        }
        long fibPrev = 1, fibTwoPrev = 1;
        for (int i = 2; i <= n; i++) {
            long result = fibPrev + fibTwoPrev;
            fibTwoPrev = fibPrev;
            fibPrev = result;
        }
        return fibPrev;
    }
}
