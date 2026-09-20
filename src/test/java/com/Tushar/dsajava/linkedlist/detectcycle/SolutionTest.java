package com.Tushar.dsajava.linkedlist.detectcycle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void shouldDetectCycle() {

        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;

        // Create cycle: 4 -> 2
        fourth.next = second;

        assertTrue(solution.hasCycle(head));
    }

    @Test
    void shouldReturnFalseWhenNoCycleExists() {

        ListNode head =
                new ListNode(
                        1,
                        new ListNode(
                                2,
                                new ListNode(3)
                        )
                );

        assertFalse(solution.hasCycle(head));
    }

    @Test
    void shouldHandleEmptyList() {

        assertFalse(solution.hasCycle(null));
    }

    @Test
    void shouldHandleSingleNodeWithoutCycle() {

        ListNode head = new ListNode(1);

        assertFalse(solution.hasCycle(head));
    }

    @Test
    void shouldHandleSingleNodeWithCycle() {

        ListNode head = new ListNode(1);

        // Create cycle: 1 -> 1
        head.next = head;

        assertTrue(solution.hasCycle(head));
    }
}