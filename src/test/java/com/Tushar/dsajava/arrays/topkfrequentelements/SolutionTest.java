package com.Tushar.dsajava.arrays.topkfrequentelements;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Top K Frequent Elements")
class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("should return top k frequent elements")
    void shouldReturnTopKFrequentElements() {

        int[] input = {
                1, 1, 1, 2, 2, 3
        };

        int[] result =
                solution.topKFrequent(input, 2);

        Arrays.sort(result);

        assertEquals(
                "[1, 2]",
                Arrays.toString(result)
        );
    }

    @Test
    @DisplayName("should handle single-element array")
    void shouldHandleSingleElement() {

        int[] input = {
                1
        };

        int[] result =
                solution.topKFrequent(input, 1);

        assertEquals(
                "[1]",
                Arrays.toString(result)
        );
    }

    @Test
    @DisplayName("should handle negative numbers")
    void shouldHandleNegativeNumbers() {

        int[] input = {
                -1, -1, -2, -2, -2, 3
        };

        int[] result =
                solution.topKFrequent(input, 1);

        assertEquals(
                "[-2]",
                Arrays.toString(result)
        );
    }

    @Test
    @DisplayName("should return all elements when k equals the number of unique elements")
    void shouldReturnAllElementsWhenKEqualsUniqueCount() {

        int[] input = {
                1, 2, 3
        };

        int[] result =
                solution.topKFrequent(input, 3);

        Arrays.sort(result);

        assertEquals(
                "[1, 2, 3]",
                Arrays.toString(result)
        );
    }
}