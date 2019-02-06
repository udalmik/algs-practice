package com.udalmik.algs.interviewbit.stackqueue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RedundantBraces {

    public int braces(String s) {

        Set<Character> operators = new HashSet<>(Arrays.asList('+', '-', '*', '/'));

        Stack<Character> chars = new Stack<>();

        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.toCharArray()[i];
            switch (c) {
                case ')':
                    if (chars.peek().equals('(')) {
                        return 1;
                    } else {
                        int opsCount = 0;
                        while (!chars.peek().equals('(')) {
                            if (operators.contains(chars.pop())) {
                                opsCount++;
                            }
                        }
                        if (opsCount == 0) {
                            return 1;
                        }
                        chars.pop();
                    }
                    break;
                default:
                    chars.push(c);
            }

        }

        return 0;

    }
}
