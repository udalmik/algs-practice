package com.udalmik.algs.interviewbit.string;

public class IndexOf {

    public int strStr(final String s, final String x) {

        if (x == null || s == null || s.isEmpty() || x.isEmpty()) {
            return -1;
        }

        char[] stringChars = s.toCharArray();
        char[] xChars = x.toCharArray();

        int start = 0;
        int current;
        int currentX = 0;

        while (start < stringChars.length) {
            if (stringChars[start] == xChars[currentX]) {
                current = start;
                while (current < stringChars.length
                        && currentX < xChars.length
                        && stringChars[current] == xChars[currentX]) {
                    current++;
                    currentX++;
                }
                if (currentX == xChars.length) {
                    return start;
                }
                currentX = 0;
            }
            start++;
            while (start < stringChars.length && stringChars[start] != xChars[0]) {
                start++;
            }
        }

        return -1;

    }
}
