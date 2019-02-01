package com.udalmik.algs.interviewbit.list;


/**
 * https://www.interviewbit.com/problems/partition-list/
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        ListNode lowHead = null;
        ListNode lowTail = null;
        ListNode highHead = null;
        ListNode highTail = null;

        while (head != null) {
            ListNode next = head.next;
            int val = head.val;
            if (val < x) {
                if (lowHead == null) {
                    lowHead = head;
                    lowTail = head;
                } else {
                    lowTail = append(lowTail, head);
                }
            } else {
                if (highHead == null) {
                    highHead = head;
                    highTail = head;
                } else {
                    highTail = append(highTail, head);
                }
            }
            head = next;
        }

        if (lowTail != null) {
            lowTail.next = highHead;
        }

        return lowHead != null ? lowHead : highHead;

    }

    private ListNode append(ListNode tail, ListNode tailNode) {
        tailNode.next = null;
        tail.next = tailNode;
        return tailNode;
    }
}
