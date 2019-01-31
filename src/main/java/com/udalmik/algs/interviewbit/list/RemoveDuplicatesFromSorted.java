package com.udalmik.algs.interviewbit.list;

public class RemoveDuplicatesFromSorted {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            if (prev != null && current.val == prev.val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }

        return head;
    }

}
