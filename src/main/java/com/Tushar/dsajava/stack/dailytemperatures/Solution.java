package com.Tushar.dsajava.stack.dailytemperatures;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    /*
     * Approach (Monotonic Decreasing Stack):
     *
     * 1. We need to find the number of days until a warmer temperature for each day.
     * 2. Brute force checks each day against all future days: O(n^2) time.
     * 3. To achieve O(n) time, we maintain a Monotonic Decreasing Stack storing day indices.
     * 4. As we iterate through each day `i`:
     *      - While current temperature `temperatures[i]` is strictly greater than the temperature
     *        at the index at the top of the stack (`temperatures[stack.peek()]`):
     *          a. Pop the earlier day's index `prevIndex`.
     *          b. Calculate the span: `i - prevIndex`.
     *          c. Store it in `result[prevIndex]`.
     *      - Push the current day's index `i` onto the stack.
     * 5. Any day indices remaining on the stack have no warmer future day, so their result stays 0.
     *
     * Why this approach:
     * Every day index is pushed onto the stack exactly once and popped at most once.
     * This processes the array in linear O(n) time while naturally maintaining chronological ordering.
     *
     * Time Complexity: O(n) where n is the number of temperatures.
     * Space Complexity: O(n) auxiliary space for the monotonic stack and output array.
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }

        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }
}
