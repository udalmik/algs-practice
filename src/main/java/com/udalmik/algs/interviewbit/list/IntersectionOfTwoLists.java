package com.udalmik.algs.interviewbit.list;

public class IntersectionOfTwoLists {

    public ListNode getIntersectionNode(ListNode a, ListNode b) {

        int lengthA = lengthOf(a);
        int lengthB = lengthOf(b);

        int diff = Math.abs(lengthA - lengthB);

        if (lengthA > lengthB) {
            a = move(a, diff);
        } else {
            b = move(b, diff);
        }

        if (a == b) return a;

        while (a != null && b != null) {
            b = b.next;
            a = a.next;
            if (a == b) return a;
        }

        return null;

    }

    private ListNode move(ListNode node, int diff) {
        while (diff-- > 0) {
            node = node.next;
        }
        return node;
    }

    public int lengthOf(ListNode head) {
        int counter = 0;
        while (head != null) {
            head = head.next;
            counter++;
        }
        return counter;
    }
}
