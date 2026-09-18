package com.Tushar.dsajava.strings.groupanagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /*
     * Approach (HashMap + Character Frequency Key):
     *
     * 1. For each string, build a 26-element integer array counting
     *    the frequency of each lowercase letter (index 0 = 'a' … 25 = 'z').
     * 2. Encode the frequency array into a canonical string key by joining
     *    counts with '#' separators (e.g., "#1#0#...#1#...").
     *    Using '#' as a separator prevents collisions between different
     *    frequency arrays that might otherwise produce the same concatenation.
     * 3. All anagrams share the same key, so they are grouped together
     *    in a HashMap under that key using computeIfAbsent.
     * 4. Return all grouped lists as the final result.
     *
     * Why this approach:
     * Sorting each string would cost O(m log m) per string (O(n·m log m) total).
     * Building a frequency array is O(m), reducing the overall cost to O(n·m).
     * The '#' delimiter ensures the key is collision-free without extra hashing.
     *
     * Time Complexity: O(n·m), where n = number of strings, m = average length
     * Space Complexity: O(n·m)
     */

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {

            // Build a 26-element frequency array for the current string
            int[] frequency = new int[26];

            for (char ch : str.toCharArray()) {
                frequency[ch - 'a']++;
            }

            // Encode the frequency array as a '#'-delimited canonical key
            StringBuilder key = new StringBuilder();

            for (int count : frequency) {
                key.append('#').append(count);
            }

            groups
                    .computeIfAbsent(key.toString(), k -> new ArrayList<>())
                    .add(str);
        }

        return new ArrayList<>(groups.values());
    }
}