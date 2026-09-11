package com.Tushar.dsajava.strings.validanagram;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

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