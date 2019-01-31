package com.udalmik.algs.interviewbit.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class IntersectionOfTwoListsTest {

    private final IntersectionOfTwoLists sut = new IntersectionOfTwoLists();

    @Test
    public void getIntersectionNode_SameLength() {
        ListNode tail = ListNode.create(Arrays.asList(1, 2));
        ListNode a = ListNode.create(Arrays.asList(3, 4), tail);
        ListNode b = ListNode.create(Arrays.asList(5, 6), tail);
        assertEquals(tail, sut.getIntersectionNode(a, b));
    }

    @Test
    public void getIntersectionNode_DiffLength() {
        ListNode tail = ListNode.create(Arrays.asList(1, 2));
        ListNode a = ListNode.create(Arrays.asList(3, 4), tail);
        ListNode b = ListNode.create(Arrays.asList(5, 6, 7), tail);
        assertEquals(tail, sut.getIntersectionNode(a, b));
    }

    @Test
    public void getIntersectionNode_WithTail() {
        ListNode tail = ListNode.create(Arrays.asList(1, 2));
        ListNode a = ListNode.create(Arrays.asList(3, 4), tail);
        assertEquals(tail, sut.getIntersectionNode(a, tail));
    }

    @Test
    public void lengthOf() {
        ListNode listNode = ListNode.create(Arrays.asList(1, 2, 3));
        assertEquals(3, sut.lengthOf(listNode));
    }
}