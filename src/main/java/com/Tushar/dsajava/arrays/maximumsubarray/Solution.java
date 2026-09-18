package com.Tushar.dsajava.arrays.maximumsubarray;

public class Solution {

    /*
     * Approach (Kadane's Algorithm):
     *
     * 1. Initialise currentSum and maxSum to the first element.
     * 2. For each subsequent element, decide whether to:
     *      a. Extend the existing subarray: currentSum + nums[i]
     *      b. Start a new subarray from this element: nums[i]
     *    Whichever is larger becomes the new currentSum.
     * 3. Update maxSum whenever currentSum exceeds it.
     *
     * Why this approach:
     * If currentSum becomes negative it can only drag down future sums,
     * so starting fresh from the current element is always better.
     * This greedy decision reduces the problem to a single O(n) pass.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public int maxSubArray(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(
                    nums[i],
                    currentSum + nums[i]
            );

            maxSum = Math.max(
                    maxSum,
                    currentSum
            );
        }

        return maxSum;
    }
}