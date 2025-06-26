package com.tomasdelizia.problems.recursion;

public class NFactorial {
    /**
     * Calculates the factorial of a number n recursively.
     * * Time complexity: O(n) due to the linear depth of recursion
     *
     * @param n the number to calculate the factorial of
     * @return the factorial of n
     */
    public static long factorial(long n) {
        if (n == 0) {
            return 1;
        }
        // Recursive case: n! = n * (n - 1)!
        // Post-order processing
        return n * factorial(n - 1);
    }
}
