package com.udalmik.algs.interviewbit.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseFromKToNTest {

    private final ReverseFromKToN sut = new ReverseFromKToN();

    @Test
    public void reverseBetween() {

        ListNode reversed = sut.reverseBetween(ListNode.create(1, 2, 3, 4, 5), 2, 4);

        assertTrue(
                ListNode.same(
                        ListNode.create(1, 4, 3, 2, 5), reversed
                )
        );
    }

    @Test
    public void reverseBetween_All() {

        ListNode reversed = sut.reverseBetween(ListNode.create(1, 2, 3, 4, 5), 1, 5);

        assertTrue(
                ListNode.same(
                        ListNode.create(5, 4, 3, 2, 1), reversed
                )
        );
    }

    @Test
    public void reverseBetween_Last() {

        ListNode reversed = sut.reverseBetween(ListNode.create(1, 2, 3, 4, 5), 3, 5);

        assertTrue(
                ListNode.same(
                        ListNode.create(1, 2, 5, 4, 3), reversed
                )
        );
    }
}