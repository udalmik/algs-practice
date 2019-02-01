package com.udalmik.algs.interviewbit.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortLinkedListTest {

    private final SortLinkedList sut = new SortLinkedList();

    @Test
    public void sortList() {

        ListNode sorted = sut.sortList(ListNode.create(4, 3, 2, 1));

        assertTrue(ListNode.same(ListNode.create(1, 2, 3, 4), sorted));

    }

    @Test
    public void merge() {

        ListNode merged = sut.merge(
                ListNode.create(2, 4, 6, 7),
                ListNode.create(1, 3, 5)
        );

        assertTrue(
                ListNode.same(
                        ListNode.create(1, 2, 3, 4, 5, 6, 7), merged
                )
        );

    }

    @Test
    public void split() {

        SortLinkedList.Tuple split = sut.split(ListNode.create(1, 2, 3, 4, 5));

        assertTrue(ListNode.same(
                ListNode.create(1, 2), split.left
        ));

        assertTrue(ListNode.same(
                ListNode.create(3, 4, 5), split.right
        ));

    }
}