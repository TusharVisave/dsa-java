package com.Tushar.dsajava.linkedlist.removenthnode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void shouldRemoveNthNodeFromEnd() {

        ListNode head =
                new ListNode(
                        1,
                        new ListNode(
                                2,
                                new ListNode(
                                        3,
                                        new ListNode(
                                                4,
                                                new ListNode(5)
                                        )
                                )
                        )
                );

        ListNode result =
                solution.removeNthFromEnd(head, 2);

        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(5, result.next.next.next.val);
        assertNull(result.next.next.next.next);
    }

    @Test
    void shouldRemoveHeadWhenNEqualsListLength() {

        ListNode head =
                new ListNode(
                        1,
                        new ListNode(
                                2,
                                new ListNode(3)
                        )
                );

        ListNode result =
                solution.removeNthFromEnd(head, 3);

        assertEquals(2, result.val);
        assertEquals(3, result.next.val);
        assertNull(result.next.next);
    }

    @Test
    void shouldRemoveLastNodeWhenNIsOne() {

        ListNode head =
                new ListNode(
                        1,
                        new ListNode(
                                2,
                                new ListNode(3)
                        )
                );

        ListNode result =
                solution.removeNthFromEnd(head, 1);

        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertNull(result.next.next);
    }

    @Test
    void shouldHandleSingleNodeList() {

        ListNode head = new ListNode(1);

        ListNode result =
                solution.removeNthFromEnd(head, 1);

        assertNull(result);
    }

    @Test
    void shouldRejectNonPositiveN() {

        ListNode head = new ListNode(1);

        assertThrows(
                IllegalArgumentException.class,
                () -> solution.removeNthFromEnd(head, 0)
        );
    }

    @Test
    void shouldRejectNGreaterThanListLength() {

        ListNode head =
                new ListNode(
                        1,
                        new ListNode(2)
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> solution.removeNthFromEnd(head, 3)
        );
    }
}