package com.Tushar.dsajava.arrays.twosum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Two Sum")
class TwoSumTest {

    @Test
    @DisplayName("should find two numbers using optimized (hash map) solution")
    void shouldFindTwoNumbersUsingOptimizedSolution() {

        int[] nums = {2, 7, 11, 15};

        assertArrayEquals(
                new int[]{0, 1},
                Solution.twoSum(nums, 9)
        );
    }

    @Test
    @DisplayName("should find two numbers using brute-force solution")
    void shouldFindTwoNumbersUsingBruteForceSolution() {

        int[] nums = {2, 7, 11, 15};

        assertArrayEquals(
                new int[]{0, 1},
                BruteForceSolution.twoSum(nums, 9)
        );
    }

    @Test
    @DisplayName("should handle single-element array")
    void shouldHandleSingleElement() {

        int[] nums = {5};

        assertArrayEquals(
                new int[]{-1, -1},
                Solution.twoSum(nums, 5)
        );
    }

    @Test
    @DisplayName("should handle empty array")
    void shouldHandleEmptyArray() {

        int[] nums = {};

        assertArrayEquals(
                new int[]{-1, -1},
                Solution.twoSum(nums, 5)
        );
    }

    @Test
    @DisplayName("should handle no valid pair")
    void shouldHandleNoValidPair() {

        int[] nums = {1, 2, 3};

        assertArrayEquals(
                new int[]{-1, -1},
                Solution.twoSum(nums, 10)
        );
    }
    @Test
    @DisplayName("should handle duplicate values")
    void shouldHandleDuplicateValues() {

        int[] nums = {3, 3};

        assertArrayEquals(
                new int[]{0, 1},
                Solution.twoSum(nums, 6)
        );
    }
    @Test
    @DisplayName("should handle negative numbers")
    void shouldHandleNegativeNumbers() {

        int[] nums = {-3, 4, 3, 90};

        assertArrayEquals(
                new int[]{0, 2},
                Solution.twoSum(nums, 0)
        );
    }
}