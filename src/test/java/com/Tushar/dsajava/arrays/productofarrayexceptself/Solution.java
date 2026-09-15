package com.Tushar.dsajava.arrays.productofarrayexceptself;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void shouldReturnProductExceptSelf() {

        int[] nums = {1, 2, 3, 4};

        int[] expected = {24, 12, 8, 6};

        assertArrayEquals(
                expected,
                solution.productExceptSelf(nums)
        );
    }

    @Test
    void shouldHandleArrayContainingZero() {

        int[] nums = {1, 2, 0, 4};

        int[] expected = {0, 0, 8, 0};

        assertArrayEquals(
                expected,
                solution.productExceptSelf(nums)
        );
    }

    @Test
    void shouldHandleNegativeNumbers() {

        int[] nums = {-1, 2, -3, 4};

        int[] expected = {-24, 12, -8, 6};

        assertArrayEquals(
                expected,
                solution.productExceptSelf(nums)
        );
    }

    @Test
    void shouldHandleTwoElements() {

        int[] nums = {2, 3};

        int[] expected = {3, 2};

        assertArrayEquals(
                expected,
                solution.productExceptSelf(nums)
        );
    }

    @Test
    void shouldHandleSingleElement() {

        int[] nums = {5};

        int[] expected = {1};

        assertArrayEquals(
                expected,
                solution.productExceptSelf(nums)
        );
    }

    @Test
    void shouldHandleMultipleZeros() {

        int[] nums = {0, 2, 0, 4};

        int[] expected = {0, 0, 0, 0};

        assertArrayEquals(
                expected,
                solution.productExceptSelf(nums)
        );
    }
}