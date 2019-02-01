package com.udalmik.algs.interviewbit.list;

import java.util.Arrays;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode create(List<Integer> values) {
        if (values.isEmpty()) return null;
        ListNode head = new ListNode(values.get(0));
        ListNode prev = head;
        for (int i = 1; i < values.size(); i++) {
            ListNode next = new ListNode(values.get(i));
            prev.next = next;
            prev = next;
        }
        return head;
    }

    public static ListNode create(List<Integer> values, ListNode tail) {
        if (values.isEmpty()) return null;
        ListNode head = new ListNode(values.get(0));
        ListNode prev = head;
        ListNode last = head;
        for (int i = 1; i < values.size(); i++) {
            last = new ListNode(values.get(i));
            prev.next = last;
            prev = last;
        }
        if (tail != null) {
            last.next = tail;
        }
        return head;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val + "}";
    }

    public static boolean same(ListNode a, ListNode b) {
        while (a != null && b != null) {
            if (a.val != b.val) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return a == b;
    }

    public static ListNode create(Integer ... i) {
        return create(Arrays.asList(i));
    }
}
