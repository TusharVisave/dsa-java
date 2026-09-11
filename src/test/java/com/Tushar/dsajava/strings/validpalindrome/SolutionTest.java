package com.Tushar.dsajava.strings.validpalindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void shouldReturnTrueForPalindrome() {
        assertTrue(solution.isPalindrome("racecar"));
    }

    @Test
    void shouldHandleMixedCaseAndPunctuation() {
        assertTrue(solution.isPalindrome(
                "A man, a plan, a canal: Panama"
        ));
    }

    @Test
    void shouldReturnFalseForNonPalindrome() {
        assertFalse(solution.isPalindrome("race a car"));
    }

    @Test
    void shouldHandleEmptyString() {
        assertTrue(solution.isPalindrome(""));
    }

    @Test
    void shouldHandleSingleCharacter() {
        assertTrue(solution.isPalindrome("a"));
    }

    @Test
    void shouldHandleAllPunctuation() {
        assertTrue(solution.isPalindrome(".,!@#$%^&*()"));
    }
}
