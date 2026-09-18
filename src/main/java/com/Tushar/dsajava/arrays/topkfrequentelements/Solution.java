package com.Tushar.dsajava.arrays.topkfrequentelements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /*
     * Approach (HashMap + Bucket Sort):
     *
     * Step 1 — frequency count:
     *   Use a HashMap to count how many times each number appears.
     *   key = number, value = frequency.
     *
     * Step 2 — bucket sort:
     *   Create an array of lists (buckets) of size n+1, where index i
     *   holds all numbers that appear exactly i times.
     *   The maximum possible frequency is n (all elements identical),
     *   so the bucket array never goes out of bounds.
     *
     * Step 3 — collect top-k:
     *   Iterate the bucket array from the highest index down.
     *   Add numbers from each bucket to the result until k are collected.
     *
     * Why this approach:
     * Sorting by frequency with a heap would cost O(n log k).
     * Bucket sort exploits the fact that frequency is bounded by n,
     * giving O(n) time and O(n) space without any comparison-based sorting.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: count element frequencies
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(
                    num,
                    frequencyMap.getOrDefault(num, 0) + 1
            );
        }

        // Step 2: place each number into the bucket at its frequency index
        List<Integer>[] buckets =
                new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry
                : frequencyMap.entrySet()) {

            int number = entry.getKey();
            int frequency = entry.getValue();

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(number);
        }

        // Step 3: iterate buckets from highest frequency, collect k elements
        int[] result = new int[k];
        int index = 0;

        for (int frequency = buckets.length - 1;
             frequency >= 0 && index < k;
             frequency--) {

            if (buckets[frequency] == null) {
                continue;
            }

            for (int number : buckets[frequency]) {

                if (index == k) {
                    break;
                }

                result[index++] = number;
            }
        }

        return result;
    }
}