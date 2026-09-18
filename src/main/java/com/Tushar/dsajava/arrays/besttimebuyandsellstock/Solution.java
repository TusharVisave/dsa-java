package com.Tushar.dsajava.arrays.besttimebuyandsellstock;


public class Solution {

    /*
     * Approach:
     *
     * 1. Track the minimum price seen so far as we iterate left to right.
     * 2. At each price, calculate the potential profit:
     *      profit = current price - minimum price so far
     * 3. Update the maximum profit whenever a better profit is found.
     * 4. Updating minPrice and maxProfit in a single pass avoids
     *    the need for a nested loop.
     *
     * Why this approach:
     * A single traversal is sufficient because the best buy day must
     * come before the best sell day. Tracking the running minimum
     * guarantees we always consider the cheapest possible buy price
     * up to the current day.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            if (price < minPrice) {
                minPrice = price;
            }

            int profit = price - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}