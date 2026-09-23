package com.Tushar.dsajava.linkedlist.intersectionoflinkedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void shouldFindIntersectionNode() {

        ListNode intersection =
                new ListNode(8);

        intersection.next =
                new ListNode(10);

        ListNode headA =
                new ListNode(
                        3,
                        new ListNode(
                                7,
                                intersection
                        )
                );

        ListNode headB =
                new ListNode(
                        99,
                        new ListNode(
                                1,
                                intersection
                        )
                );

        ListNode result =
                solution.getIntersectionNode(
                        headA,
                        headB
                );

        assertSame(intersection, result);
    }

    @Test
    void shouldReturnNullWhenListsDoNotIntersect() {

        ListNode headA =
                new ListNode(
                        1,
                        new ListNode(2)
                );

        ListNode headB =
                new ListNode(
                        3,
                        new ListNode(4)
                );

        ListNode result =
                solution.getIntersectionNode(
                        headA,
                        headB
                );

        assertNull(result);
    }

    @Test
    void shouldHandleSameHead() {

        ListNode head =
                new ListNode(
                        1,
                        new ListNode(2)
                );

        ListNode result =
                solution.getIntersectionNode(
                        head,
                        head
                );

        assertSame(head, result);
    }

    @Test
    void shouldHandleNullFirstList() {

        ListNode headB =
                new ListNode(1);

        ListNode result =
                solution.getIntersectionNode(
                        null,
                        headB
                );

        assertNull(result);
    }

    @Test
    void shouldHandleNullSecondList() {

        ListNode headA =
                new ListNode(1);

        ListNode result =
                solution.getIntersectionNode(
                        headA,
                        null
                );

        assertNull(result);
    }
}