package com.Tushar.dsajava.arrays.maximumsubarray;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Maximum Subarray")
class MaximumSubarrayTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("should find maximum subarray sum")
    void shouldFindMaximumSubarray() {

        int[] nums = {
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        };

        assertEquals(
                6,
                solution.maxSubArray(nums)
        );
    }

    @Test
    @DisplayName("should handle all negative numbers")
    void shouldHandleAllNegativeNumbers() {

        int[] nums = {-2, -1, -3};

        assertEquals(
                -1,
                solution.maxSubArray(nums)
        );
    }

    @Test
    @DisplayName("should handle single element")
    void shouldHandleSingleElement() {

        int[] nums = {5};

        assertEquals(
                5,
                solution.maxSubArray(nums)
        );
    }

    @Test
    @DisplayName("should handle all positive numbers")
    void shouldHandleAllPositiveNumbers() {

        int[] nums = {1, 2, 3, 4};

        assertEquals(
                10,
                solution.maxSubArray(nums)
        );
    }

    @Test
    @DisplayName("should handle empty array")
    void shouldHandleEmptyArray() {

        int[] nums = {};

        assertEquals(
                0,
                solution.maxSubArray(nums)
        );
    }
}