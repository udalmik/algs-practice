package com.udalmik.algs.interviewbit.hash;

import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {

    public int colorful(int a) {

        String s = String.valueOf(a);

        Set<Integer> exists = new HashSet<>();

        for (int subLength = 0; subLength < s.length(); subLength++) {

            for (int i = 0; i + subLength < s.length(); i++) {
                String substring = s.substring(i, i + subLength + 1);

                int multiplication = substring.chars()
                        .mapToObj(c -> Character.getNumericValue((char) c))
                        .mapToInt(c -> c)
                        .reduce(1, Math::multiplyExact);

                if (exists.contains(multiplication)) {
                    return 0;
                } else {
                    exists.add(multiplication);
                }

            }
        }

        return 1;

    }
}
