package com.udalmik.algs.interviewbit.stackqueue;

import java.util.Stack;

public class ValidateBraces {

    public int isValid(String s) {

        Stack<Character> chars = new Stack<>();

        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            switch (c) {
                case '(':
                case '{':
                case '[':
                    chars.push(c);
                    break;
                case ')':
                    if (chars.isEmpty() || !chars.pop().equals('(')) {
                        return 0;
                    }
                    break;
                case ']':
                    if (chars.isEmpty() || !chars.pop().equals('[')) {
                        return 0;
                    }
                    break;
                case '}':
                    if (chars.isEmpty() || !chars.pop().equals('{')) {
                        return 0;
                    }
                    break;
            }
        }

        return chars.isEmpty() ? 1 : 0;

    }
}
