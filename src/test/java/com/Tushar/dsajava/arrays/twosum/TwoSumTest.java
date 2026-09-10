package com.Tushar.dsajava.arrays.twosum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    @Test
    void shouldFindTwoNumbersUsingOptimizedSolution() {

        int[] nums = {2, 7, 11, 15};

        assertArrayEquals(
                new int[]{0, 1},
                Solution.twoSum(nums, 9)
        );
    }

    @Test
    void shouldFindTwoNumbersUsingBruteForceSolution() {

        int[] nums = {2, 7, 11, 15};

        assertArrayEquals(
                new int[]{0, 1},
                BruteForceSolution.twoSum(nums, 9)
        );
    }

    @Test
    void shouldHandleSingleElement() {

        int[] nums = {5};

        assertArrayEquals(
                new int[]{-1, -1},
                Solution.twoSum(nums, 5)
        );
    }

    @Test
    void shouldHandleEmptyArray() {

        int[] nums = {};

        assertArrayEquals(
                new int[]{-1, -1},
                Solution.twoSum(nums, 5)
        );
    }

    @Test
    void shouldHandleNoValidPair() {

        int[] nums = {1, 2, 3};

        assertArrayEquals(
                new int[]{-1, -1},
                Solution.twoSum(nums, 10)
        );
    }
    @Test
    void shouldHandleDuplicateValues() {

        int[] nums = {3, 3};

        assertArrayEquals(
                new int[]{0, 1},
                Solution.twoSum(nums, 6)
        );
    }
    @Test
    void shouldHandleNegativeNumbers() {

        int[] nums = {-3, 4, 3, 90};

        assertArrayEquals(
                new int[]{0, 2},
                Solution.twoSum(nums, 0)
        );
    }
}