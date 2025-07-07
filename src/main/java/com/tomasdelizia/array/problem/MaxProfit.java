package com.tomasdelizia.array.problem;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int maxProfit = 0;
        int currentBestPrice = prices[0];
        for (int i = 1; i < n; i++) {
            int currentPrice = prices[i];
            int profit = currentPrice - currentBestPrice;
            if (profit > 0) {
                maxProfit += profit;
            }
            currentBestPrice = currentPrice;
        }
        return maxProfit;
    }

    public static int maxProfitSingleTransaction(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (Integer price : prices) {
            minPrice = Math.min(price, minPrice);
            int profit = price - minPrice;
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }
}
