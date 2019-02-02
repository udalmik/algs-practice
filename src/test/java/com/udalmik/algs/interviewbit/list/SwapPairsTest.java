package com.udalmik.algs.interviewbit.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwapPairsTest {

    private final SwapPairs sut = new SwapPairs();

    @Test
    public void swapPairs() {

        ListNode swapped = sut.swapPairs(ListNode.create(1, 2, 3, 4));

        assertTrue(
                ListNode.same(
                        ListNode.create(2, 1, 4, 3), swapped
                )
        );

    }

    @Test
    public void swapPairs_Odd() {

        ListNode swapped = sut.swapPairs(ListNode.create(1, 2, 3));

        assertTrue(
                ListNode.same(
                        ListNode.create(2, 1, 3), swapped
                )
        );

    }
}