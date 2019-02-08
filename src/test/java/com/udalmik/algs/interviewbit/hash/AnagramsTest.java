package com.udalmik.algs.interviewbit.hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class AnagramsTest {

    private final Anagrams sut = new Anagrams();

    @Test
    public void anagrams() {

        ArrayList<ArrayList<Integer>> expected =
                new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1, 4)), new ArrayList<>(Arrays.asList(2, 3))));
        assertEquals(expected, sut.anagrams(Arrays.asList("cat", "dog", "god", "tca")));

    }
}