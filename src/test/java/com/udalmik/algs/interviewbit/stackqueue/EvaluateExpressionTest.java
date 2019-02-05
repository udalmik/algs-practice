package com.udalmik.algs.interviewbit.stackqueue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class EvaluateExpressionTest {

    private final EvaluateExpression sut = new EvaluateExpression();

    @Test
    public void evalRPN() {
        assertEquals(9, sut.evalRPN(new ArrayList<>(Arrays.asList("2", "1", "+", "3", "*"))));
        assertEquals(6, sut.evalRPN(new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+"))));
    }
}