package com.Tushar.dsajava.stack.dailytemperatures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Daily Temperatures")
class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("should compute wait days for standard mixed temperature profile")
    void shouldComputeWaitDaysForStandardInput() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};

        assertArrayEquals(expected, solution.dailyTemperatures(temperatures));
    }

    @Test
    @DisplayName("should return all 1s except last for strictly increasing temperatures")
    void shouldHandleStrictlyIncreasingTemperatures() {
        int[] temperatures = {30, 40, 50, 60};
        int[] expected = {1, 1, 1, 0};

        assertArrayEquals(expected, solution.dailyTemperatures(temperatures));
    }

    @Test
    @DisplayName("should return all 0s for strictly decreasing temperatures")
    void shouldHandleStrictlyDecreasingTemperatures() {
        int[] temperatures = {90, 80, 70, 60};
        int[] expected = {0, 0, 0, 0};

        assertArrayEquals(expected, solution.dailyTemperatures(temperatures));
    }

    @Test
    @DisplayName("should return all 0s for equal temperatures")
    void shouldHandleEqualTemperatures() {
        int[] temperatures = {70, 70, 70, 70};
        int[] expected = {0, 0, 0, 0};

        assertArrayEquals(expected, solution.dailyTemperatures(temperatures));
    }

    @Test
    @DisplayName("should handle single element")
    void shouldHandleSingleElement() {
        int[] temperatures = {85};
        int[] expected = {0};

        assertArrayEquals(expected, solution.dailyTemperatures(temperatures));
    }

    @Test
    @DisplayName("should handle empty array")
    void shouldHandleEmptyArray() {
        int[] temperatures = {};
        int[] expected = {};

        assertArrayEquals(expected, solution.dailyTemperatures(temperatures));
    }

    @Test
    @DisplayName("should handle null input")
    void shouldHandleNullInput() {
        int[] expected = {};

        assertArrayEquals(expected, solution.dailyTemperatures(null));
    }

    @Test
    @DisplayName("should handle sub-zero / negative temperatures")
    void shouldHandleNegativeTemperatures() {
        int[] temperatures = {-5, -10, 0, -2, 5};
        int[] expected = {2, 1, 2, 1, 0};

        assertArrayEquals(expected, solution.dailyTemperatures(temperatures));
    }

    @Test
    @DisplayName("should handle fluctuating temperature patterns")
    void shouldHandleFluctuatingTemperatures() {
        int[] temperatures = {30, 60, 90};
        int[] expected = {1, 1, 0};

        assertArrayEquals(expected, solution.dailyTemperatures(temperatures));
    }

    @Test
    @DisplayName("should handle repeated values with later greater value")
    void shouldHandleRepeatedValuesWithLaterGreaterValue() {
        int[] temperatures = {50, 50, 60};
        int[] expected = {2, 1, 0};

        assertArrayEquals(expected, solution.dailyTemperatures(temperatures));
    }
}
