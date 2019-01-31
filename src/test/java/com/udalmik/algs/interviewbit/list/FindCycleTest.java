package com.udalmik.algs.interviewbit.list;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FindCycleTest {

    private final FindCycle sut = new FindCycle();

    @Test
    public void detectCycle() {

        ListNode cycleNode = new ListNode(4);
        ListNode cycle = new ListNode(3, cycleNode);
        cycleNode.next = cycle;

        ListNode list = ListNode.create(Arrays.asList(1, 2), cycle);

        assertEquals(cycle, sut.detectCycle(list));

    }
}