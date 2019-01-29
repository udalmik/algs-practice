package com.udalmik.algs.interviewbit.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeIntegerTest {

    private PalindromeInteger sut = new PalindromeInteger();

    @Test
    public void isPalindrome() {
        assertEquals(1, sut.isPalindrome(11));
        assertEquals(1, sut.isPalindrome(121));
        assertEquals(1, sut.isPalindrome(0));
        assertEquals(1, sut.isPalindrome(1));
        assertEquals(0, sut.isPalindrome(112));
        assertEquals(0, sut.isPalindrome(-2147447412));
    }

    @Test
    public void byIndex() {
        assertEquals(1, sut.byIndex(123, 3));
        assertEquals(2, sut.byIndex(123, 2));
        assertEquals(3, sut.byIndex(123, 1));
    }
}