package com.udalmik.algs.interviewbit.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExcelColumnNumberTest {

    private ExcelColumnNumber sut = new ExcelColumnNumber();

    @Test
    public void titleToNumber() {

        assertEquals(28, sut.titleToNumber("AB"));
        assertEquals(26, sut.titleToNumber("Z"));
    }
}