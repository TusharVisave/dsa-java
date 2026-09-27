package com.Tushar.dsajava.stack.reversenotation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void shouldEvaluateSimpleExpression() {
        String[] tokens = {"2", "1", "+", "3", "*"};

        assertEquals(9, solution.evalRPN(tokens));
    }

    @Test
    void shouldEvaluateComplexExpression() {
        String[] tokens = {"4", "13", "5", "/", "+"};

        assertEquals(6, solution.evalRPN(tokens));
    }

    @Test
    void shouldRespectSubtractionOrder() {
        String[] tokens = {"5", "3", "-"};

        assertEquals(2, solution.evalRPN(tokens));
    }

    @Test
    void shouldRespectDivisionOrder() {
        String[] tokens = {"10", "2", "/"};

        assertEquals(5, solution.evalRPN(tokens));
    }

    @Test
    void shouldHandleNegativeNumbers() {
        String[] tokens = {"4", "-2", "/"};

        assertEquals(-2, solution.evalRPN(tokens));
    }

    @Test
    void shouldHandleNegativeResult() {
        String[] tokens = {"2", "5", "-"};

        assertEquals(-3, solution.evalRPN(tokens));
    }

    @Test
    void shouldHandleSingleNumber() {
        String[] tokens = {"42"};

        assertEquals(42, solution.evalRPN(tokens));
    }

    @Test
    void shouldHandleMultiplication() {
        String[] tokens = {"6", "7", "*"};

        assertEquals(42, solution.evalRPN(tokens));
    }

    @Test
    void shouldRejectNullTokens() {
        assertThrows(
                IllegalArgumentException.class,
                () -> solution.evalRPN(null)
        );
    }

    @Test
    void shouldRejectEmptyTokens() {
        assertThrows(
                IllegalArgumentException.class,
                () -> solution.evalRPN(new String[]{})
        );
    }

    @Test
    void shouldRejectExpressionWithMissingOperand() {
        String[] tokens = {"2", "+"};

        assertThrows(
                IllegalArgumentException.class,
                () -> solution.evalRPN(tokens)
        );
    }

    @Test
    void shouldRejectExpressionWithExtraOperands() {
        String[] tokens = {"2", "3"};

        assertThrows(
                IllegalArgumentException.class,
                () -> solution.evalRPN(tokens)
        );
    }

    @Test
    void shouldRejectInvalidToken() {
        String[] tokens = {"2", "abc", "+"};

        assertThrows(
                IllegalArgumentException.class,
                () -> solution.evalRPN(tokens)
        );
    }

    @Test
    void shouldRejectDivisionByZero() {
        String[] tokens = {"10", "0", "/"};

        assertThrows(
                ArithmeticException.class,
                () -> solution.evalRPN(tokens)
        );
    }
}