package com.tomasdelizia.problems.dynamic;

public class DynamicCoinChange {
    /**
     * Dynamic programming algorithm to find the minimum number of coins needed to make a given amount.
     * This approach works for any set of coin denominations, not just those that allow a greedy solution.
     *
     * @param coins an array of coin denominations
     * @param x     the target amount
     * @return the minimum number of coins needed to make the amount x
     */
    public static int dynamicCoinChange(int[] coins, int x) {
        int[] minCoinsPerValue = new int[x + 1];
        // If x = 0, 0 coins are needed
        for (int v = 1; v < x + 1; v++) {
            // Find the min coins for each value between 1 and x
            // minCoinsPerValue[v] = Min(v, Min(1 + minCoinsPerValue[i]))
            // where i = v - minCoinsPerValue[j] for each coin j
            int minValue = v;
            for (int coinValue : coins) {
                // We can't use the coin if it's larger than v
                if (coinValue > v) {
                    continue;
                }
                int difference = v - coinValue;
                int coinsToCoverDiference = minCoinsPerValue[difference];
                minValue = Math.min(minValue, 1 + coinsToCoverDiference);
            }
            minCoinsPerValue[v] = minValue;
        }
        return minCoinsPerValue[x];
    }

}
