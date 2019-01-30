package com.udalmik.algs.interviewbit.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RearrangeArrayTest {

    private final RearrangeArray sut = new RearrangeArray();

    @Test
    public void arrangeSimple() {
        {
            ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 0));
            sut.arrange(input);
            assertEquals(Arrays.asList(0, 1), input);
        }
        {
            ArrayList<Integer> input = new ArrayList<>(Arrays.asList(4, 0, 2, 1, 3));
            sut.arrange(input);
            assertEquals(Arrays.asList(3, 4, 2, 0, 1), input);
        }
    }

}