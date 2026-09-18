package com.Tushar.dsajava.arrays.topkfrequentelements;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
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