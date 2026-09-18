package com.Tushar.dsajava.strings.validanagram;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /*
     * Approach (Frequency Map):
     *
     * 1. Early-exit if the strings differ in length — they cannot be anagrams.
     * 2. Build a frequency map by iterating over string s:
     *      increment the count for each character encountered.
     * 3. Iterate over string t, decrementing the count for each character.
     *      If a character is not in the map, t has a character s does not — return false.
     *      When a count reaches zero, remove the entry to keep the map clean.
     * 4. If the map is empty after processing t, both strings have identical
     *    character frequencies — return true.
     *
     * Why this approach:
     * HashMap provides O(1) average-case operations, making a single-pass
     * check sufficient. The early length check avoids unnecessary work.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(k), where k is the number of distinct characters
     */

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Build frequency map from s
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Decrement counts using t; any mismatch means not an anagram
        for (char ch : t.toCharArray()) {
            if (!frequencyMap.containsKey(ch)) {
                return false;
            }

            frequencyMap.put(ch, frequencyMap.get(ch) - 1);

            if (frequencyMap.get(ch) == 0) {
                frequencyMap.remove(ch);
            }
        }

        return frequencyMap.isEmpty();
    }
}