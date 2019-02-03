package com.udalmik.algs.interviewbit.list;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RemoveNthNodeTest {

    private final RemoveNthNode sut = new RemoveNthNode();

    @Test
    public void removeNthFromEnd_Middle() {
        ListNode result = sut.removeNthFromEnd(ListNode.create(1, 2, 3), 2);
        assertTrue(
                ListNode.same(
                        ListNode.create(1, 3), result
                )
        );
    }

    @Test
    public void removeNthFromEnd_Last() {
        ListNode result = sut.removeNthFromEnd(ListNode.create(1, 2, 3), 1);
        assertTrue(
                ListNode.same(
                        ListNode.create(1, 2), result
                )
        );
    }

    @Test
    public void removeNthFromEnd_First() {
        ListNode result = sut.removeNthFromEnd(ListNode.create(1, 2, 3), 3);
        assertTrue(
                ListNode.same(
                        ListNode.create(2, 3), result
                )
        );
    }
}