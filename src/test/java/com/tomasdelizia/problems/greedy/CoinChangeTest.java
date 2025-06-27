package com.tomasdelizia.problems.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinChangeTest {

    @Test
    void greedyCoinChangeTest() {
        int[] coins = {1, 5, 10, 25};
        int x = 30;
        // Expected 2: 25 + 5
        assertEquals(2, CoinChange.greedyCoinChange(coins, x));

        coins = new int[]{1, 2, 5};
        x = 11;
        // Expected 3: 5 + 5 + 1
        assertEquals(3, CoinChange.greedyCoinChange(coins, x));

        coins = new int[]{2, 3, 7};
        x = 14;
        // Expected 2:  7 + 7
        assertEquals(2, CoinChange.greedyCoinChange(coins, x));

        coins = new int[]{1};
        x = 0;
        // Expected 0: No coins needed for zero amount
        assertEquals(0, CoinChange.greedyCoinChange(coins, x));
    }
}