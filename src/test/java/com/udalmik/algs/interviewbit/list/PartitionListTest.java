package com.udalmik.algs.interviewbit.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PartitionListTest {

    private final PartitionList sut = new PartitionList();

    @Test
    public void partition() {

        ListNode partitioned = sut.partition(ListNode.create(Arrays.asList(1, 4, 3, 2, 5, 2)), 3);

        assertTrue(
                ListNode.same(
                        ListNode.create(Arrays.asList(1, 2, 2, 4, 3, 5)), partitioned
                )
        );

    }

    @Test
    public void partitionOneLow() {

        ListNode partitioned = sut.partition(ListNode.create(Arrays.asList(1)), 3);

        assertTrue(
                ListNode.same(
                        ListNode.create(Arrays.asList(1)), partitioned
                )
        );

    }

    @Test
    public void partitionOneHigh() {

        ListNode partitioned = sut.partition(ListNode.create(Arrays.asList(6)), 3);

        assertTrue(
                ListNode.same(
                        ListNode.create(Arrays.asList(6)), partitioned
                )
        );

    }
}