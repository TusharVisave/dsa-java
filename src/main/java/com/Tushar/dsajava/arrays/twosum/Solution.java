package com.Tushar.dsajava.arrays.twosum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /*
     * Approach:
     *
     * 1. Create a HashMap to store each number and its index.
     * 2. For every number, calculate its complement:
     *      complement = target - current number
     * 3. Check whether the complement already exists in the HashMap.
     * 4. If it exists, return the complement index and current index.
     * 5. Otherwise, store the current number and its index.
     *
     * Why this approach:
     * HashMap provides average O(1) lookup, reducing the
     * overall time complexity from O(n^2) to O(n).
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}