package com.Tushar.dsajava.linkedlist.reverselinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void shouldReverseLinkedList() {

        ListNode head =
                new ListNode(
                        1,
                        new ListNode(
                                2,
                                new ListNode(3)
                        )
                );

        ListNode result =
                solution.reverseList(head);

        assertEquals(3, result.val);
        assertEquals(2, result.next.val);
        assertEquals(1, result.next.next.val);
        assertNull(result.next.next.next);
    }

    @Test
    void shouldHandleSingleNode() {

        ListNode head =
                new ListNode(1);

        ListNode result =
                solution.reverseList(head);

        assertEquals(1, result.val);
        assertNull(result.next);
    }

    @Test
    void shouldHandleEmptyList() {

        ListNode result =
                solution.reverseList(null);

        assertNull(result);
    }
}