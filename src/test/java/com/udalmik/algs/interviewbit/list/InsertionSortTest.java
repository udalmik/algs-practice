package com.udalmik.algs.interviewbit.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSortTest {


    private final InsertionSort sut = new InsertionSort();

    @Test
    public void insertionSortList() {

        ListNode sorted = sut.insertionSortList(ListNode.create(1, 5, 5, 4));

        assertTrue(
                ListNode.same(
                        ListNode.create(1, 4, 5, 5), sorted
                )
        );

    }

    @Test
    public void insertionSortList_Sorted() {

        ListNode sorted = sut.insertionSortList(ListNode.create(1, 4, 4, 5));

        assertTrue(
                ListNode.same(
                        ListNode.create(1, 4, 4, 5), sorted
                )
        );

    }

    @Test
    public void insertionSortList_AllElements() {

        ListNode sorted = sut.insertionSortList(ListNode.create(3, 2, 1));

        assertTrue(
                ListNode.same(
                        ListNode.create(1, 2, 3), sorted
                )
        );

    }
}