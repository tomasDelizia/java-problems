package com.tomasdelizia.problems.greedy;

import com.tomasdelizia.arrays.ArraySearcher;
import com.tomasdelizia.arrays.ArraySorter;
import com.tomasdelizia.arrays.SortOrder;

public class GreedyCoinChange {
    /**
     * Greedy algorithm to find the minimum number of coins needed to make a given amount.
     * The coins must be sorted in descending order for the greedy approach to work correctly.
     *
     * @param coins an array of coin denominations
     * @param x     the target amount
     * @return the minimum number of coins needed to make the amount x
     */
    public static int greedyCoinChange(int[] coins, int x) {
        // Check if one coin is the solution
        if (ArraySearcher.binarySearch(coins, x) != -1) {
            return 1;
        }
        // Coins must be sorted in descending order
        ArraySorter.shellSort(coins, SortOrder.DESCENDING);

        // Greedy rule to find the minimum number of coins
        int count = 0, amount = 0;
        for (int coinValue : coins) {
            while (amount + coinValue <= x) {
                amount += coinValue;
                count++;
            }
            if (amount == x) {
                break;
            }
        }
        return count;
    }
}
