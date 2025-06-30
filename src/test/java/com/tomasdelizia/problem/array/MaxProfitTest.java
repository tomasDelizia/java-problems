package com.tomasdelizia.problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxProfitTest {

    @Test
    void maxProfit() {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int expectedProfit1 = 7; // Buy at 1, sell at 5, buy at 3, sell at 6
        assertEquals(expectedProfit1, MaxProfit.maxProfit(prices1));

        int[] prices2 = {7, 6, 4, 3, 1};
        int expectedProfit2 = 0; // No transactions can be made
        assertEquals(expectedProfit2, MaxProfit.maxProfit(prices2));

        int[] prices3 = {1, 2, 3, 4, 5};
        int expectedProfit3 = 4; // Buy at 1 and sell at 5
        assertEquals(expectedProfit3, MaxProfit.maxProfit(prices3));

        int[] prices4 = {};
        int expectedProfit4 = 0; // No prices available
        assertEquals(expectedProfit4, MaxProfit.maxProfit(prices4));
    }
}