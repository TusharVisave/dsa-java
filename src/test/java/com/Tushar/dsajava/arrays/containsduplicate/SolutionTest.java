package com.Tushar.dsajava.arrays.containsduplicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Contains Duplicate")
class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("should return true when array contains a duplicate")
    void shouldReturnTrueWhenArrayContainsDuplicate() {
        int[] nums = {1, 2, 3, 1};

        assertTrue(solution.containsDuplicate(nums));
    }

    @Test
    @DisplayName("should return false when array contains no duplicates")
    void shouldReturnFalseWhenArrayContainsNoDuplicate() {
        int[] nums = {1, 2, 3, 4};

        assertFalse(solution.containsDuplicate(nums));
    }

    @Test
    @DisplayName("should return true when duplicate is adjacent")
    void shouldReturnTrueWhenDuplicateIsAdjacent() {
        int[] nums = {1, 1};

        assertTrue(solution.containsDuplicate(nums));
    }

    @Test
    @DisplayName("should return false for single-element array")
    void shouldReturnFalseForSingleElementArray() {
        int[] nums = {1};

        assertFalse(solution.containsDuplicate(nums));
    }

    @Test
    @DisplayName("should handle negative numbers")
    void shouldHandleNegativeNumbers() {
        int[] nums = {-1, -2, -3, -1};

        assertTrue(solution.containsDuplicate(nums));
    }

    @Test
    @DisplayName("should handle zero")
    void shouldHandleZero() {
        int[] nums = {0, 1, 2, 0};

        assertTrue(solution.containsDuplicate(nums));
    }
}