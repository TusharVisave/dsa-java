package com.Tushar.dsajava.stack.validparentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void shouldReturnTrueForSinglePair() {
        assertTrue(solution.isValid("()"));
    }

    @Test
    void shouldReturnTrueForMultipleBracketTypes() {
        assertTrue(solution.isValid("()[]{}"));
    }

    @Test
    void shouldReturnTrueForNestedBrackets() {
        assertTrue(solution.isValid("([{}])"));
    }

    @Test
    void shouldReturnTrueForMixedNestedBrackets() {
        assertTrue(solution.isValid("{[()]}"));
    }

    @Test
    void shouldReturnFalseForMismatchedBrackets() {
        assertFalse(solution.isValid("(]"));
    }

    @Test
    void shouldReturnFalseForIncorrectNesting() {
        assertFalse(solution.isValid("([)]"));
    }

    @Test
    void shouldReturnFalseWhenClosingBracketAppearsFirst() {
        assertFalse(solution.isValid("]"));
    }

    @Test
    void shouldReturnFalseForUnclosedOpeningBracket() {
        assertFalse(solution.isValid("((("));
    }

    @Test
    void shouldReturnTrueForEmptyString() {
        assertTrue(solution.isValid(""));
    }

    @Test
    void shouldReturnFalseForNullInput() {
        assertFalse(solution.isValid(null));
    }

    @Test
    void shouldReturnFalseForUnsupportedCharacters() {
        assertFalse(solution.isValid("(a)"));
    }
}