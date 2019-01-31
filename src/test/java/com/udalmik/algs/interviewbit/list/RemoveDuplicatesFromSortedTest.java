package com.udalmik.algs.interviewbit.list;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RemoveDuplicatesFromSortedTest {

    private final RemoveDuplicatesFromSorted sut = new RemoveDuplicatesFromSorted();

    @Test
    public void testRemoveDuplicates() {
        assertTrue(ListNode.same(
                ListNode.create(Arrays.asList(1, 2, 3)),
                        sut.deleteDuplicates(ListNode.create(Arrays.asList(1, 2, 2, 2, 3, 3)))
        ));

        assertTrue(ListNode.same(
                ListNode.create(Arrays.asList(1, 2, 3)),
                sut.deleteDuplicates(ListNode.create(Arrays.asList(1, 1, 2, 3, 3)))
        ));

        assertTrue(ListNode.same(
                ListNode.create(Arrays.asList(1, 2, 3)),
                sut.deleteDuplicates(ListNode.create(Arrays.asList(1, 2, 3)))
        ));
    }

}