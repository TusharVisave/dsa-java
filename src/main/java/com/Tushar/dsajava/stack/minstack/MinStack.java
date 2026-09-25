package com.Tushar.dsajava.stack.minstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Stack that supports retrieving the minimum element in O(1) time.
 */
public class MinStack {

    private final Deque<Integer> stack;
    private final Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    /**
     * Adds a value to the stack.
     *
     * @param value value to push
     */
    public void push(int value) {
        stack.push(value);

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    /**
     * Removes the top element.
     *
     * @return removed value
     * @throws IllegalStateException if stack is empty
     */
    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        int removed = stack.pop();

        if (removed == minStack.peek()) {
            minStack.pop();
        }

        return removed;
    }

    /**
     * Returns the top element without removing it.
     *
     * @return top value
     * @throws IllegalStateException if stack is empty
     */
    public int top() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return stack.peek();
    }

    /**
     * Returns the minimum value currently in the stack.
     *
     * @return minimum value
     * @throws IllegalStateException if stack is empty
     */
    public int getMin() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return minStack.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}