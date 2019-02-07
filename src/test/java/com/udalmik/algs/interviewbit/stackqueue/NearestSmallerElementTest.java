package com.udalmik.algs.interviewbit.stackqueue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class NearestSmallerElementTest {

    private final NearestSmallerElement sut = new NearestSmallerElement();

    @Test
    public void prevSmaller() {
        assertEquals(
                Arrays.asList(-1, 4, -1, 2, 2), sut.prevSmaller(new ArrayList<>(Arrays.asList(4, 5, 2, 10, 8)))
        );
    }
}