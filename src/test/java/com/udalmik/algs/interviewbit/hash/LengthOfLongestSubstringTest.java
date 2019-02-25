package com.udalmik.algs.interviewbit.hash;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthOfLongestSubstringTest {

    private final LengthOfLongestSubstring sut = new LengthOfLongestSubstring();

    @Test
    public void testSimple() {
        assertEquals(3, sut.lengthOfLongestSubstring("aaaabcababbb"));
        assertEquals(4, sut.lengthOfLongestSubstring("dadbc"));
    }

}