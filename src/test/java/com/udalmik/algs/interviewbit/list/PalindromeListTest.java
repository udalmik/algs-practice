package com.udalmik.algs.interviewbit.list;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PalindromeListTest {

    private final PalindromeList sut = new PalindromeList();

    @Test
    public void lPalin() {
        assertEquals(1, sut.lPalin(ListNode.create(Arrays.asList(1, 2, 3, 2, 1))));
        assertEquals(0, sut.lPalin(ListNode.create(Arrays.asList(1, 3, 3, 2, 1))));
        assertEquals(1, sut.lPalin(ListNode.create(Arrays.asList(1, 2, 2, 1))));
        assertEquals(1, sut.lPalin(ListNode.create(Arrays.asList(1, 2, 1))));
        assertEquals(1, sut.lPalin(ListNode.create(Arrays.asList(1))));
        assertEquals(1, sut.lPalin(ListNode.create(Arrays.asList(1, 1))));
    }
}