package com.udalmik.algs.interviewbit.hash;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    // without repeating characters
    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();

        if (chars.length == 0) return 0;
        if (chars.length == 1) return 1;

        Set<Character> unique = new HashSet<>();
        unique.add(chars[0]);

        int start = 0;
        int end = 1;

        int max = 1;

        while (end < chars.length) {
            char endChar = chars[end];
            if (unique.contains(endChar)) {
                while (unique.contains(endChar) && start < end) {
                    unique.remove(chars[start++]);
                }
            } else {
                unique.add(endChar);
                if (max < unique.size()) {
                    max = unique.size();
                }
                end++;
            }
        }

        return max;

    }
}
