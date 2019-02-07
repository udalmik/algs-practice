package com.udalmik.algs.interviewbit.hash;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorfulNumberTest {

    private final ColorfulNumber sut = new ColorfulNumber();

    @Test
    public void colorful() {
        assertEquals(1, sut.colorful(23));
        assertEquals(0, sut.colorful(232));
        assertEquals(0, sut.colorful(2361));
        assertEquals(0, sut.colorful(12));
        assertEquals(0, sut.colorful(233223));
    }
}