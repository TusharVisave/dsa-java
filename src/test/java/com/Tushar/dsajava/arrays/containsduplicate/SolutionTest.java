package com.Tushar.dsajava.arrays.containsduplicate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void shouldReturnTrueWhenArrayContainsDuplicate() {
        int[] nums = {1, 2, 3, 1};

        assertTrue(solution.containsDuplicate(nums));
    }

    @Test
    void shouldReturnFalseWhenArrayContainsNoDuplicate() {
        int[] nums = {1, 2, 3, 4};

        assertFalse(solution.containsDuplicate(nums));
    }

    @Test
    void shouldReturnTrueWhenDuplicateIsAdjacent() {
        int[] nums = {1, 1};

        assertTrue(solution.containsDuplicate(nums));
    }

    @Test
    void shouldReturnFalseForSingleElementArray() {
        int[] nums = {1};

        assertFalse(solution.containsDuplicate(nums));
    }

    @Test
    void shouldHandleNegativeNumbers() {
        int[] nums = {-1, -2, -3, -1};

        assertTrue(solution.containsDuplicate(nums));
    }

    @Test
    void shouldHandleZero() {
        int[] nums = {0, 1, 2, 0};

        assertTrue(solution.containsDuplicate(nums));
    }
}