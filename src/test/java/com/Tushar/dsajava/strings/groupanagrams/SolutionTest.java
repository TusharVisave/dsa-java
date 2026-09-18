package com.Tushar.dsajava.strings.groupanagrams;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Group Anagrams")
class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("should group anagrams together")
    void shouldGroupAnagrams() {

        String[] input = {
                "eat",
                "tea",
                "tan",
                "ate",
                "nat",
                "bat"
        };

        List<List<String>> result =
                solution.groupAnagrams(input);

        Set<Set<String>> expected = Set.of(
                Set.of("eat", "tea", "ate"),
                Set.of("tan", "nat"),
                Set.of("bat")
        );

        Set<Set<String>> actual = new HashSet<>();

        for (List<String> group : result) {
            actual.add(new HashSet<>(group));
        }

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should handle empty input array")
    void shouldHandleEmptyInput() {

        String[] input = {};

        List<List<String>> result =
                solution.groupAnagrams(input);

        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("should handle single word")
    void shouldHandleSingleWord() {

        String[] input = {
                "hello"
        };

        List<List<String>> result =
                solution.groupAnagrams(input);

        assertEquals(
                Set.of(Set.of("hello")),
                toSet(result)
        );
    }

    private Set<Set<String>> toSet(List<List<String>> groups) {

        Set<Set<String>> result = new HashSet<>();

        for (List<String> group : groups) {
            result.add(new HashSet<>(group));
        }

        return result;
    }
}