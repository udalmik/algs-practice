package com.udalmik.algs.interviewbit.list;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class KReverseLinkedListTest {

    private final KReverseLinkedList sut = new KReverseLinkedList();

    @Test
    public void reverseList() {
        ListNode reversed = sut.reverseList(ListNode.create(Arrays.asList(1, 2, 3, 4)), 2);
        assertTrue(ListNode.same(
                ListNode.create(Arrays.asList(2, 1, 4, 3)),
                        reversed));

    }
}