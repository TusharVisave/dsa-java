package com.Tushar.dsajava.linkedlist.removenthnode;

public class Solution {

    public ListNode removeNthFromEnd(
            ListNode head,
            int n
    ) {

        if (n <= 0) {
            throw new IllegalArgumentException(
                    "n must be positive"
            );
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {

            if (fast.next == null) {
                throw new IllegalArgumentException(
                        "n cannot be greater than list length"
                );
            }

            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}