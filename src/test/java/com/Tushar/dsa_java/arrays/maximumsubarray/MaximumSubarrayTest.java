package com.Tushar.dsa_java.arrays.maximumsubarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSubarrayTest {

    @Test
    void shouldFindMaximumSubarray() {

        int[] nums = {
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        };

        assertEquals(
                6,
                Solution.maxSubArray(nums)
        );
    }

    @Test
    void shouldHandleAllNegativeNumbers() {

        int[] nums = {-2, -1, -3};

        assertEquals(
                -1,
                Solution.maxSubArray(nums)
        );
    }

    @Test
    void shouldHandleSingleElement() {

        int[] nums = {5};

        assertEquals(
                5,
                Solution.maxSubArray(nums)
        );
    }

    @Test
    void shouldHandleAllPositiveNumbers() {

        int[] nums = {1, 2, 3, 4};

        assertEquals(
                10,
                Solution.maxSubArray(nums)
        );
    }

    @Test
    void shouldHandleEmptyArray() {

        int[] nums = {};

        assertEquals(
                0,
                Solution.maxSubArray(nums)
        );
    }
}