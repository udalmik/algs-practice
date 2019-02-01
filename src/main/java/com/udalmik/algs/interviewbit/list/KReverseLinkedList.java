package com.udalmik.algs.interviewbit.list;

public class KReverseLinkedList {

    public ListNode reverseList(ListNode head, int k) {

        int length = lengthOf(head);

        int chunks = length / k;

        ListNode current = head;
        ListNode prev = null;
        ListNode prevHead = null;

        for (int i = 0; i < chunks; i++) {

            int count = k;
            ListNode chunkOldHead = current;

            while (count > 0) {
                ListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
                count--;
            }

            if (prevHead != null) {
                prevHead.next = prev;
            }

            prevHead = chunkOldHead;

            if (i == chunks - 1) {
                chunkOldHead.next = null;
            }

            if (i == 0) {
                head = prev;
            }
        }

        return head;

    }

    private int lengthOf(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
