package com.udalmik.algs.interviewbit.list;

public class RotateList {

    public ListNode rotateRight(ListNode head, int n) {

        if (head == null || head.next == null) return head;

        int length = length(head);

        n %= length;

        if (n == 0) return head;

        int splitPoint = length - n - 1;

        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }

        ListNode current = head;
        while (splitPoint-- > 0) {
            current = current.next;
        }

        ListNode newHead = current.next;
        current.next = null;
        last.next = head;

        return newHead;
    }

    private int length(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }


}
