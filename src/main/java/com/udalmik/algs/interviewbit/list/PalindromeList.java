package com.udalmik.algs.interviewbit.list;

public class PalindromeList {

    /**
     *  Constraints: Expected solution is linear in time and constant in space.
     */
    public int lPalin(ListNode head) {

        if (head == null || head.next == null) {
            return 1;
        }

        // find middle and end of list

        ListNode end = head;
        int length = 0;
        while (end != null) {
            length++;
            end = end.next;
        }

        int middle = length/2 + 1;
        ListNode midNode = head;
        while (middle > 1) {
            midNode = midNode.next;
            middle--;
        }

        // reverse from middle
        ListNode current = midNode;
        ListNode prev = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        ListNode reversedTail = prev;
        current = head;
        while (current != midNode) {
            if (current.val != reversedTail.val) {
                return 0;
            }
            current = current.next;
            reversedTail = reversedTail.next;
        }

        return 1;

    }

}
