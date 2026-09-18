package com.Tushar.dsajava.strings.validanagram;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Valid Anagram")
class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("should return true for a valid anagram")
    void shouldReturnTrueForValidAnagram() {
        assertTrue(solution.isAnagram("anagram", "nagaram"));
    }

    @Test
    @DisplayName("should return false for an invalid anagram")
    void shouldReturnFalseForInvalidAnagram() {
        assertFalse(solution.isAnagram("rat", "car"));
    }

    @Test
    @DisplayName("should return false when strings have different lengths")
    void shouldReturnFalseForDifferentLengths() {
        assertFalse(solution.isAnagram("abc", "ab"));
    }

    @Test
    @DisplayName("should handle empty strings")
    void shouldHandleEmptyStrings() {
        assertTrue(solution.isAnagram("", ""));
    }

    @Test
    @DisplayName("should handle single character")
    void shouldHandleSingleCharacter() {
        assertTrue(solution.isAnagram("a", "a"));
        assertFalse(solution.isAnagram("a", "b"));
    }
}
