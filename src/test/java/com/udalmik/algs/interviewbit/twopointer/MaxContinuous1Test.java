package com.udalmik.algs.interviewbit.twopointer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class MaxContinuous1Test {

    private MaxContinuous1 sut = new MaxContinuous1();

    @Test
    public void maxOneSimple() {
        assertEquals(
                Arrays.asList(5, 6, 7, 8, 9),
                sut.maxone(new ArrayList<>(Arrays.asList(1, 0, 0, 0, 0, 0, 1, 0, 1, 1)), 2));
    }

    @Test
    public void maxOneSimple2() {
        assertEquals(
                Arrays.asList(0, 1, 2, 3),
                sut.maxone(new ArrayList<>(Arrays.asList(1, 1, 0, 0, 0, 0, 1)), 2));
    }

    @Test
    public void maxOneAllZeros() {
        assertEquals(
                Arrays.asList(0, 1),
                sut.maxone(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0)), 2));
    }

    @Test
    public void maxOneLeadingZeros() {
        assertEquals(
                Arrays.asList(2, 3, 4),
                sut.maxone(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1)), 1));
    }

    @Test
    public void maxOneLong() {
        assertEquals(
                IntStream.range(0, 40).boxed().collect(Collectors.toCollection(ArrayList::new)),
                sut.maxone(new ArrayList<>(Arrays.asList(0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 )), 20));
    }

    @Test
    public void maxOneSparsed() {
        assertEquals(
                IntStream.range(4, 16).boxed().collect(Collectors.toCollection(ArrayList::new)),
                sut.maxone(new ArrayList<>(Arrays.asList(1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0)), 4));
    }
}