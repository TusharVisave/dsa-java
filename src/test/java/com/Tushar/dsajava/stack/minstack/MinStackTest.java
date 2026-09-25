package com.Tushar.dsajava.stack.minstack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    @Test
    void shouldPushAndReturnTopElement() {
        MinStack stack = new MinStack();

        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.top());
    }

    @Test
    void shouldReturnMinimumElement() {
        MinStack stack = new MinStack();

        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(2);

        assertEquals(2, stack.getMin());
    }

    @Test
    void shouldUpdateMinimumAfterPop() {
        MinStack stack = new MinStack();

        stack.push(5);
        stack.push(3);
        stack.push(2);

        assertEquals(2, stack.getMin());

        stack.pop();

        assertEquals(3, stack.getMin());
    }

    @Test
    void shouldHandleDuplicateMinimumValues() {
        MinStack stack = new MinStack();

        stack.push(5);
        stack.push(2);
        stack.push(2);
        stack.push(7);

        assertEquals(2, stack.getMin());

        stack.pop();
        assertEquals(2, stack.getMin());

        stack.pop();
        assertEquals(2, stack.getMin());

        stack.pop();
        assertEquals(5, stack.getMin());
    }

    @Test
    void shouldReturnTopAfterPop() {
        MinStack stack = new MinStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop());
        assertEquals(20, stack.top());
    }

    @Test
    void shouldReportEmptyStack() {
        MinStack stack = new MinStack();

        assertTrue(stack.isEmpty());
    }

    @Test
    void shouldBecomeEmptyAfterRemovingAllElements() {
        MinStack stack = new MinStack();

        stack.push(10);
        stack.pop();

        assertTrue(stack.isEmpty());
    }

    @Test
    void shouldThrowWhenPoppingEmptyStack() {
        MinStack stack = new MinStack();

        assertThrows(
                IllegalStateException.class,
                stack::pop
        );
    }

    @Test
    void shouldThrowWhenReadingTopOfEmptyStack() {
        MinStack stack = new MinStack();

        assertThrows(
                IllegalStateException.class,
                stack::top
        );
    }

    @Test
    void shouldThrowWhenReadingMinimumOfEmptyStack() {
        MinStack stack = new MinStack();

        assertThrows(
                IllegalStateException.class,
                stack::getMin
        );
    }

    @Test
    void shouldHandleNegativeValues() {
        MinStack stack = new MinStack();

        stack.push(-5);
        stack.push(-10);
        stack.push(-3);

        assertEquals(-10, stack.getMin());
    }
}