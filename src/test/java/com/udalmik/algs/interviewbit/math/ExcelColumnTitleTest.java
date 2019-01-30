package com.udalmik.algs.interviewbit.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExcelColumnTitleTest {

    private final ExcelColumnTitle sut = new ExcelColumnTitle();

    @Test
    public void testCellToTitle() {
//        assertEquals("Z", sut.convertToTitle(26));
//        assertEquals("AB", sut.convertToTitle(28));
        assertEquals("BAQTZ", sut.convertToTitle(943566));
    }

}