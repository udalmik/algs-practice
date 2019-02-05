package com.udalmik.algs.interviewbit.stackqueue;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimplifyDirectoryPathTest {

    private final SimplifyDirectoryPath sut = new SimplifyDirectoryPath();

    @Test
    public void simplifyPath() {
        assertEquals("/c", sut.simplifyPath("/a/./b/../../c/"));
        assertEquals("/c", sut.simplifyPath("/a/b/../../c/"));
        assertEquals("/a/b", sut.simplifyPath("/a/b/c/.."));
        assertEquals("/a/b/c", sut.simplifyPath("/a/b/c/"));
    }
}