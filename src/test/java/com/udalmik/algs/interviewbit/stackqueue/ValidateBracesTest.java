package com.udalmik.algs.interviewbit.stackqueue;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateBracesTest {

    private final ValidateBraces sut = new ValidateBraces();

    @Test
    public void isValid() {
        assertEquals(1, sut.isValid("(){}[]"));
        assertEquals(1, sut.isValid("((){()}[{}])"));
        assertEquals(0, sut.isValid("(((){()}[{}])"));
        assertEquals(0, sut.isValid("(()"));
    }
}