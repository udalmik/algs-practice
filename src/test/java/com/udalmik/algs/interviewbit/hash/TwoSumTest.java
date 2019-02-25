package com.udalmik.algs.interviewbit.hash;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TwoSumTest {

    private final TwoSum sut = new TwoSum();

    @Test
    public void twoSum() {
        assertEquals(Arrays.asList(2, 3), sut.twoSum(Arrays.asList(1, 2, 7, 3, 5), 9));
        assertEquals(Arrays.asList(1, 3), sut.twoSum(Arrays.asList(2, 2, 7, 3, 3), 9));
        assertEquals(Arrays.asList(4, 8), sut.twoSum(Arrays.asList( 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8
), -3));
    }
}