package com.udalmik.algs.interviewbit.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateListTest {

    private final RotateList sut = new RotateList();

    @Test
    public void rotateRight() {

        ListNode rotated = sut.rotateRight(ListNode.create(1, 2, 3, 4, 5), 2);

        assertTrue(
                ListNode.same(
                        ListNode.create(4, 5, 1, 2, 3), rotated
                )
        );
    }

    @Test
    public void rotateRight_MoreThanLength() {

        ListNode rotated = sut.rotateRight(ListNode.create(1, 2, 3, 4, 5), 7);

        assertTrue(
                ListNode.same(
                        ListNode.create(4, 5, 1, 2, 3), rotated
                )
        );
    }

    @Test
    public void rotateRight_FullCycle() {

        ListNode rotated = sut.rotateRight(ListNode.create(1, 2, 3, 4, 5), 10);

        assertTrue(
                ListNode.same(
                        ListNode.create(1, 2, 3, 4, 5), rotated
                )
        );
    }
}