package com.Tushar.dsajava.arrays.besttimebuyandsellstock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Best Time to Buy and Sell Stock")
class BestTimeToBuyAndSellStockTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("should calculate maximum profit")
    void shouldCalculateMaximumProfit() {

        int[] prices = {7, 1, 5, 3, 6, 4};

        assertEquals(
                5,
                solution.maxProfit(prices)
        );
    }

    @Test
    @DisplayName("should return zero when prices only decrease")
    void shouldReturnZeroWhenPricesOnlyDecrease() {

        int[] prices = {7, 6, 4, 3, 1};

        assertEquals(
                0,
                solution.maxProfit(prices)
        );
    }

    @Test
    @DisplayName("should handle single day")
    void shouldHandleSingleDay() {

        int[] prices = {5};

        assertEquals(
                0,
                solution.maxProfit(prices)
        );
    }

    @Test
    @DisplayName("should handle same prices on all days")
    void shouldHandleSamePrices() {

        int[] prices = {5, 5, 5, 5};

        assertEquals(
                0,
                solution.maxProfit(prices)
        );
    }
}