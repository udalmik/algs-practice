package com.udalmik.algs.interviewbit.list;

public class InsertionSort {


    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = null;
        ListNode outerCurrent = head;

        while (outerCurrent != null) {

            ListNode temp = outerCurrent;
            ListNode outerNext = outerCurrent.next;

            if (result == null || result.val >= temp.val) {
                temp.next = result;
                result = temp;
            } else {
                ListNode innerCurrent = result;
                while (innerCurrent.next != null && innerCurrent.next.val < temp.val) {
                    innerCurrent = innerCurrent.next;
                }
                temp.next = innerCurrent.next;
                innerCurrent.next = temp;
            }

            outerCurrent = outerNext;
        }
        return result;
    }

}
