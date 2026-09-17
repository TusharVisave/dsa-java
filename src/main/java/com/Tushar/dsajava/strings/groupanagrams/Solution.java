package com.Tushar.dsajava.strings.groupanagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {

            int[] frequency = new int[26];

            for (char ch : str.toCharArray()) {
                frequency[ch - 'a']++;
            }

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