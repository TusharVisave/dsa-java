package com.Tushar.dsajava.queue.implementqueueusingstacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MyQueue - Implement Queue using Stacks Tests")
class MyQueueTest {

    private MyQueue queue;

    @BeforeEach
    void setUp() {
        queue = new MyQueue();
    }

    @Test
    @DisplayName("Should report empty on newly created queue")
    void shouldReportEmptyOnNewQueue() {
        assertTrue(queue.empty());
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    @DisplayName("Should push element and return it via peek")
    void shouldPushAndPeekFirstElement() {
        queue.push(10);
        assertFalse(queue.empty());
        assertFalse(queue.isEmpty());
        assertEquals(10, queue.peek());
        assertEquals(1, queue.size());
    }

    @Test
    @DisplayName("Should maintain FIFO order across multiple push and pop operations")
    void shouldPopElementsInFifoOrder() {
        queue.push(1);
        queue.push(2);
        queue.push(3);

        assertEquals(3, queue.size());
        assertEquals(1, queue.peek());
        assertEquals(1, queue.pop());

        assertEquals(2, queue.peek());
        assertEquals(2, queue.pop());

        assertEquals(3, queue.peek());
        assertEquals(3, queue.pop());

        assertTrue(queue.empty());
        assertEquals(0, queue.size());
    }

    @Test
    @DisplayName("Should handle interleaved push and pop operations correctly")
    void shouldHandleInterleavedPushAndPop() {
        queue.push(1);
        queue.push(2);
        assertEquals(1, queue.pop());

        queue.push(3);
        queue.push(4);
        assertEquals(2, queue.pop());

        assertEquals(3, queue.peek());
        assertEquals(3, queue.pop());

        queue.push(5);
        assertEquals(4, queue.pop());
        assertEquals(5, queue.pop());

        assertTrue(queue.empty());
    }

    @Test
    @DisplayName("Should allow repeated peeks without mutating the queue state")
    void shouldAllowRepeatedPeeksWithoutMutatingState() {
        queue.push(42);
        queue.push(99);

        assertEquals(42, queue.peek());
        assertEquals(42, queue.peek());
        assertEquals(42, queue.peek());
        assertEquals(2, queue.size());
        assertEquals(42, queue.pop());
        assertEquals(99, queue.peek());
    }

    @Test
    @DisplayName("Should become empty after exhausting all inserted elements")
    void shouldBecomeEmptyAfterExhaustingAllElements() {
        queue.push(100);
        assertFalse(queue.empty());

        assertEquals(100, queue.pop());
        assertTrue(queue.empty());
        assertEquals(0, queue.size());
    }

    @Test
    @DisplayName("Should throw IllegalStateException when popping an empty queue")
    void shouldThrowWhenPoppingEmptyQueue() {
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> queue.pop()
        );
        assertEquals("Queue is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw IllegalStateException when peeking an empty queue")
    void shouldThrowWhenPeekingEmptyQueue() {
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> queue.peek()
        );
        assertEquals("Queue is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw IllegalStateException after exhausting all elements")
    void shouldThrowAfterExhaustingElements() {
        queue.push(7);
        assertEquals(7, queue.pop());

        assertThrows(
                IllegalStateException.class,
                () -> queue.pop()
        );
        assertThrows(
                IllegalStateException.class,
                () -> queue.peek()
        );
    }

    @Test
    @DisplayName("Should correctly handle negative numbers and zero")
    void shouldHandleNegativeNumbersAndZero() {
        queue.push(0);
        queue.push(-15);
        queue.push(25);
        queue.push(-999);

        assertEquals(0, queue.pop());
        assertEquals(-15, queue.pop());
        assertEquals(25, queue.pop());
        assertEquals(-999, queue.pop());
        assertTrue(queue.empty());
    }

    @Test
    @DisplayName("Should correctly handle large volume of elements maintaining FIFO order")
    void shouldHandleLargeVolumeOfElements() {
        int count = 10_000;
        for (int i = 0; i < count; i++) {
            queue.push(i);
        }

        assertEquals(count, queue.size());

        for (int i = 0; i < count; i++) {
            assertEquals(i, queue.peek());
            assertEquals(i, queue.pop());
        }

        assertTrue(queue.empty());
        assertEquals(0, queue.size());
    }
}
