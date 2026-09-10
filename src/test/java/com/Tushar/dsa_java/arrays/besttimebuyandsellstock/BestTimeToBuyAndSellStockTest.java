package com.Tushar.dsa_java.arrays.besttimebuyandsellstock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockTest {

    @Test
    void shouldCalculateMaximumProfit() {

        int[] prices = {7, 1, 5, 3, 6, 4};

        assertEquals(
                5,
                Solution.maxProfit(prices)
        );
    }

    @Test
    void shouldReturnZeroWhenPricesOnlyDecrease() {

        int[] prices = {7, 6, 4, 3, 1};

        assertEquals(
                0,
                Solution.maxProfit(prices)
        );
    }

    @Test
    void shouldHandleSingleDay() {

        int[] prices = {5};

        assertEquals(
                0,
                Solution.maxProfit(prices)
        );
    }

    @Test
    void shouldHandleSamePrices() {

        int[] prices = {5, 5, 5, 5};

        assertEquals(
                0,
                Solution.maxProfit(prices)
        );
    }
}