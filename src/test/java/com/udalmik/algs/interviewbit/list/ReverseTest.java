package com.udalmik.algs.interviewbit.list;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ReverseTest {

    private final Reverse sut = new Reverse();

    @Test
    public void reverseList() {
        assertTrue(ListNode.same(ListNode.create(
                Arrays.asList(1, 2, 3, 4)
        ), sut.reverseList(ListNode.create(Arrays.asList(4, 3, 2, 1)))));
    }
}