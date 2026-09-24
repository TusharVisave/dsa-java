package com.Tushar.dsajava.stack.validparentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public boolean isValid(String s) {

        if (s == null) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char current : s.toCharArray()) {

            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
                continue;
            }

            if (current != ')' && current != '}' && current != ']') {
                return false;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char opening = stack.pop();

            if (!isMatchingPair(opening, current)) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')')
                || (opening == '{' && closing == '}')
                || (opening == '[' && closing == ']');
    }
}