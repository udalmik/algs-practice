package com.udalmik.algs.interviewbit.list;

/**
 * https://www.interviewbit.com/problems/sort-list/
 */
public class SortLinkedList {


    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;

        Tuple divided = split(head);

        divided.left = sortList(divided.left);
        divided.right = sortList(divided.right);

        return merge(divided.left, divided.right);
    }

    public ListNode merge(ListNode left, ListNode right) {

        if (left == null) return right;
        if (right == null) return left;

        ListNode mergedHead = null;
        ListNode mergedTail = null;

        while (left != null && right != null) {
            ListNode nextMerged;
            if (left.val < right.val) {
                nextMerged = left;
                left = left.next;
            } else {
                nextMerged = right;
                right = right.next;
            }
            nextMerged.next = null;
            if (mergedHead == null) {
                mergedHead = mergedTail = nextMerged;
            } else {
                mergedTail.next = nextMerged;
                mergedTail = nextMerged;
            }
        }

        if (left != null) {
            mergedTail.next = left;
        }

        if (right != null) {
            mergedTail.next = right;
        }

        return mergedHead;
    }

    public Tuple split(ListNode head) {

        if (head.next == null) {
            return new Tuple(head, null);
        }

        int length = lengthOf(head);

        int leftCounter = length / 2;

        ListNode left = head;

        while (leftCounter > 1) {
            head = head.next;
            leftCounter--;
        }

        ListNode right = head.next;
        head.next = null;

        return new Tuple(left, right);
    }

    private int lengthOf(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    class Tuple {
        public ListNode left;
        public ListNode right;
        public Tuple(ListNode left, ListNode right) {
            this.left = left;
            this.right = right;
        }
    }

}
