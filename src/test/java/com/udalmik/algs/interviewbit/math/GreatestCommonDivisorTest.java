package com.udalmik.algs.interviewbit.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class GreatestCommonDivisorTest {

    private GreatestCommonDivisor sut = new GreatestCommonDivisor();

    @Test
    public void gcd() {
        assertEquals(3, sut.gcd(3, 6));
        assertEquals(2, sut.gcd(2, 0));
    }
}