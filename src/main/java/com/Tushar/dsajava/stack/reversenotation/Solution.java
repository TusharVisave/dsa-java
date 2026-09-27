package com.Tushar.dsajava.stack.reversenotation;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int evalRPN(String[] tokens) {

        if (tokens == null || tokens.length == 0) {
            throw new IllegalArgumentException(
                    "Tokens must not be null or empty"
            );
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {

            if (isOperator(token)) {

                if (stack.size() < 2) {
                    throw new IllegalArgumentException(
                            "Invalid Reverse Polish Notation expression"
                    );
                }

                int right = stack.pop();
                int left = stack.pop();

                int result = switch (token) {
                    case "+" -> left + right;

                    case "-" -> left - right;

                    case "*" -> left * right;

                    case "/" -> {
                        if (right == 0) {
                            throw new ArithmeticException(
                                    "Division by zero"
                            );
                        }

                        yield left / right;
                    }

                    default -> throw new IllegalStateException(
                            "Unsupported operator: " + token
                    );
                };

                stack.push(result);

            } else {

                try {
                    stack.push(Integer.parseInt(token));
                } catch (NumberFormatException exception) {
                    throw new IllegalArgumentException(
                            "Invalid token: " + token,
                            exception
                    );
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException(
                    "Invalid Reverse Polish Notation expression"
            );
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return "+".equals(token)
                || "-".equals(token)
                || "*".equals(token)
                || "/".equals(token);
    }
}