package com.Tushar.dsajava.queue.implementqueueusingstacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implementation of a First-In-First-Out (FIFO) queue using two stacks.
 *
 * Supports standard queue operations: push, pop, peek, and empty.
 * All operations run in amortized O(1) time.
 */
public class MyQueue {

    private final Deque<Integer> inStack;
    private final Deque<Integer> outStack;

    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    /**
     * Pushes element x to the back of the queue.
     *
     * @param x value to enqueue
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from the front of the queue and returns it.
     *
     * @return the front element
     * @throws IllegalStateException if the queue is empty
     */
    public int pop() {
        shiftStacks();

        if (outStack.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return outStack.pop();
    }

    /**
     * Get the front element without removing it.
     *
     * @return the front element
     * @throws IllegalStateException if the queue is empty
     */
    public int peek() {
        shiftStacks();

        if (outStack.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     *
     * @return true if queue is empty, false otherwise
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    /**
     * Standard Java idiomatic alias for empty().
     *
     * @return true if queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return empty();
    }

    /**
     * Returns the total number of elements currently in the queue.
     *
     * @return element count
     */
    public int size() {
        return inStack.size() + outStack.size();
    }

    /**
     * Transfers elements from inStack to outStack if outStack is empty.
     * This reverses the LIFO order of inStack into the FIFO order needed for dequeue.
     */
    private void shiftStacks() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
