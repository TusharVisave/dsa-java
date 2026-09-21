package com.Tushar.dsajava.linkedlist.mergetwosortedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void shouldMergeTwoSortedLists() {

        ListNode list1 =
                new ListNode(
                        1,
                        new ListNode(
                                3,
                                new ListNode(5)
                        )
                );

        ListNode list2 =
                new ListNode(
                        2,
                        new ListNode(
                                4,
                                new ListNode(6)
                        )
                );

        ListNode result =
                solution.mergeTwoLists(list1, list2);

        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
        assertEquals(5, result.next.next.next.next.val);
        assertEquals(6, result.next.next.next.next.next.val);
        assertNull(result.next.next.next.next.next.next);
    }

    @Test
    void shouldHandleFirstListEmpty() {

        ListNode list2 =
                new ListNode(
                        1,
                        new ListNode(2)
                );

        ListNode result =
                solution.mergeTwoLists(null, list2);

        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertNull(result.next.next);
    }

    @Test
    void shouldHandleSecondListEmpty() {

        ListNode list1 =
                new ListNode(
                        1,
                        new ListNode(2)
                );

        ListNode result =
                solution.mergeTwoLists(list1, null);

        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertNull(result.next.next);
    }

    @Test
    void shouldHandleBothListsEmpty() {

        ListNode result =
                solution.mergeTwoLists(null, null);

        assertNull(result);
    }

    @Test
    void shouldHandleDuplicateValues() {

        ListNode list1 =
                new ListNode(
                        1,
                        new ListNode(3)
                );

        ListNode list2 =
                new ListNode(
                        1,
                        new ListNode(3)
                );

        ListNode result =
                solution.mergeTwoLists(list1, list2);

        assertEquals(1, result.val);
        assertEquals(1, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(3, result.next.next.next.val);
        assertNull(result.next.next.next.next);
    }
}