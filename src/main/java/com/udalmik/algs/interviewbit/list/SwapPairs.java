package com.udalmik.algs.interviewbit.list;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode left = head;
        ListNode right = head.next;
        ListNode result = head.next;
        ListNode prev = null;
        do {

            ListNode nextLeft = right.next;
            ListNode nextRight = right.next != null ? right.next.next : null;

            // swap
            if (prev != null) {
                prev.next = right;
            }

            ListNode temp = right.next;
            right.next = left;
            left.next = temp;

            prev = left;
            left = nextLeft;
            right = nextRight;

        } while (left != null && right != null);

        return result;

    }
}
