package com.udalmik.algs.interviewbit.hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class LargestContinuousZeroSumTest {

    private final LargestContinuousZeroSum sut = new LargestContinuousZeroSum();

    @Test
    public void lszero() {
        ArrayList<Integer> res = sut.lszero(new ArrayList<>(Arrays.asList(1, 2, -3, 3 )));
        assertEquals(Arrays.asList(1, 2, -3), res);
    }

    @Test
    public void lszero_long() {
        ArrayList<Integer> res = sut.lszero(new ArrayList<>(Arrays.asList(-9, -13, 6, -28, 27, -5, -27, 17, 15, -17, -25, 6, -8, 2, -13, -13, -23, 21, -4, 22, -9, -10, 0, -28, -11, 8, 8, 17)));
        assertEquals(Arrays.asList(6, -28, 27, -5), res);
    }

}