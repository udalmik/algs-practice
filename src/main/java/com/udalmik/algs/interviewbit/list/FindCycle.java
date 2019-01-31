package com.udalmik.algs.interviewbit.list;

public class FindCycle {

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) return null;

        if (head == head.next) return head;

        if (head.next.next == null) return null;

        // check if cycle exists with slow and fast pointers

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow != fast) {
            return null;
        }

        // we are in cycle!

        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }
}
