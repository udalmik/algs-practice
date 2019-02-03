package com.udalmik.algs.interviewbit.list;

public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int length = length(head);

        if (n >= length) {
            ListNode next = head.next;
            head.next = null;
            return next;
        }

        int steps = length - n;

        ListNode current = head;
        ListNode prev = null;

        while (steps-- > 0) {
            prev = current;
            current = current.next;
        }

        if (prev != null) {
            prev.next = current.next;
        }

        return head;

    }

    private int length(ListNode head) {
        int counter = 0;
        while (head != null) {
            counter++;
            head = head.next;
        }
        return counter;
    }

}
