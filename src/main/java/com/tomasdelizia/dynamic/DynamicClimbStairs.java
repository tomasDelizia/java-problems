package com.tomasdelizia.dynamic;

public class DynamicClimbStairs {

    public static int climbStairs(int n) {
        int[] solutionsPerStairs = new int[n+1];
        if (n < 3) return n;
        solutionsPerStairs[1] = 1;
        solutionsPerStairs[2] = 2;
        for (int i = 3; i <= n; i++) {
            solutionsPerStairs[i] = solutionsPerStairs[i-1] + solutionsPerStairs[i-2];
        }
        return solutionsPerStairs[n];
    }
}
