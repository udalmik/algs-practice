package com.udalmik.algs.interviewbit.stackqueue;

import org.junit.Test;

import static org.junit.Assert.*;

public class RedundantBracesTest {

    private final RedundantBraces sut = new RedundantBraces();

    @Test
    public void braces() {
        assertEquals(1, sut.braces("((a + b))"));
        assertEquals(1, sut.braces("(a)"));
        assertEquals(1, sut.braces("(a + ((a + b)))"));
        assertEquals(0, sut.braces("(a + (a + b))"));
        assertEquals(0, sut.braces("a + b + c"));
    }
}