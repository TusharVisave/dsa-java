package com.Tushar.dsajava.arrays.productofarrayexceptself;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Product of Array Except Self")
class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("should return product of array except self")
    void shouldReturnProductExceptSelf() {

        int[] nums = {1, 2, 3, 4};

        int[] expected = {24, 12, 8, 6};

        assertArrayEquals(
                expected,
                solution.productExceptSelf(nums)
        );
    }

    @Test
    @DisplayName("should handle array containing a zero")
    void shouldHandleArrayContainingZero() {

        int[] nums = {1, 2, 0, 4};

        int[] expected = {0, 0, 8, 0};

        assertArrayEquals(
                expected,
                solution.productExceptSelf(nums)
        );
    }

    @Test
    @DisplayName("should handle negative numbers")
    void shouldHandleNegativeNumbers() {

        int[] nums = {-1, 2, -3, 4};

        int[] expected = {-24, 12, -8, 6};

        assertArrayEquals(
                expected,
                solution.productExceptSelf(nums)
        );
    }

    @Test
    @DisplayName("should handle two-element array")
    void shouldHandleTwoElements() {

        int[] nums = {2, 3};

        int[] expected = {3, 2};

        assertArrayEquals(
                expected,
                solution.productExceptSelf(nums)
        );
    }

    @Test
    @DisplayName("should handle single-element array")
    void shouldHandleSingleElement() {

        int[] nums = {5};

        int[] expected = {1};

        assertArrayEquals(
                expected,
                solution.productExceptSelf(nums)
        );
    }

    @Test
    @DisplayName("should handle multiple zeros")
    void shouldHandleMultipleZeros() {

        int[] nums = {0, 2, 0, 4};

        int[] expected = {0, 0, 0, 0};

        assertArrayEquals(
                expected,
                solution.productExceptSelf(nums)
        );
    }
}