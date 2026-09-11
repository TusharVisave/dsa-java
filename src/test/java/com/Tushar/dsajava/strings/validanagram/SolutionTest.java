package com.Tushar.dsajava.strings.validanagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void shouldReturnTrueForValidAnagram() {
        assertTrue(solution.isAnagram("anagram", "nagaram"));
    }

    @Test
    void shouldReturnFalseForInvalidAnagram() {
        assertFalse(solution.isAnagram("rat", "car"));
    }

    @Test
    void shouldReturnFalseForDifferentLengths() {
        assertFalse(solution.isAnagram("abc", "ab"));
    }

    @Test
    void shouldHandleEmptyStrings() {
        assertTrue(solution.isAnagram("", ""));
    }

    @Test
    void shouldHandleSingleCharacter() {
        assertTrue(solution.isAnagram("a", "a"));
        assertFalse(solution.isAnagram("a", "b"));
    }
}
