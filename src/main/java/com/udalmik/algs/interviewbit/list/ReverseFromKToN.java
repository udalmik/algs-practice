package com.udalmik.algs.interviewbit.list;

public class ReverseFromKToN {

    public ListNode reverseBetween(ListNode head, int k, int n) {

        if (head == null || head.next == null) {
            return head;
        }

        if (k == n) {
            return head;
        }

        int diff = n - k;

        ListNode current = head;
        ListNode prev = null;

        while (--k > 0) {
            prev = current;
            current = current.next;
        }

        ListNode kPrev = prev;
        ListNode kNode = current;

        while (diff-- > 0) {
            current = current.next;
        }

        ListNode nNode = current;
        ListNode nNext = current.next;
        nNode.next = null;

        ListNode reversed = reverseList(kNode);

        if (kPrev != null) {
            kPrev.next = reversed;
        }

        kNode.next = nNext;

        return kPrev != null ? head : reversed;

    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }
}
