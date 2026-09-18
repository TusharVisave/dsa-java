package com.Tushar.dsajava.strings.validpalindrome;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Valid Palindrome")
class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("should return true for a palindrome")
    void shouldReturnTrueForPalindrome() {
        assertTrue(solution.isPalindrome("racecar"));
    }

    @Test
    @DisplayName("should handle mixed case and punctuation")
    void shouldHandleMixedCaseAndPunctuation() {
        assertTrue(solution.isPalindrome(
                "A man, a plan, a canal: Panama"
        ));
    }

    @Test
    @DisplayName("should return false for a non-palindrome")
    void shouldReturnFalseForNonPalindrome() {
        assertFalse(solution.isPalindrome("race a car"));
    }

    @Test
    @DisplayName("should handle empty string")
    void shouldHandleEmptyString() {
        assertTrue(solution.isPalindrome(""));
    }

    @Test
    @DisplayName("should handle single character")
    void shouldHandleSingleCharacter() {
        assertTrue(solution.isPalindrome("a"));
    }

    @Test
    @DisplayName("should handle string with only punctuation")
    void shouldHandleAllPunctuation() {
        assertTrue(solution.isPalindrome(".,!@#$%^&*()"));
    }
}
