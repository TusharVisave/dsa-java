package com.Tushar.dsajava.arrays.topkfrequentelements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(
                    num,
                    frequencyMap.getOrDefault(num, 0) + 1
            );
        }

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