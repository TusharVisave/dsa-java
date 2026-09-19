package com.Tushar.dsajava.linkedlist.reverselinkedlist;

public class Solution {

    public ListNode reverseList(ListNode head) {

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {

            ListNode next = current.next;

            current.next = previous;

            previous = current;
            current = next;
        }

        return previous;
    }
}