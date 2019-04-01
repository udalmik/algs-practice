package com.udalmik.algs.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LetterPhone {

    private final Map<Integer, String[]> codes = new HashMap<>();
    {
        codes.put(1, new String[] {"1"});
        codes.put(2, new String[] {"a", "b", "c"});
        codes.put(3, new String[] {"d", "e", "f"});
        codes.put(4, new String[] {"g", "h", "i"});
        codes.put(5, new String[] {"j", "k", "l"});
        codes.put(6, new String[] {"m", "n", "o"});
        codes.put(7, new String[] {"p", "q", "r", "s"});
        codes.put(8, new String[] {"t", "u", "v"});
        codes.put(9, new String[] {"w", "x", "y", "z"});
        codes.put(0, new String[] {"0"});
    }

    public ArrayList<String> letterCombinations(String s) {
        char[] chars = s.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            int numericValue = Character.getNumericValue(chars[i]);
            final String[] letters = codes.get(numericValue);
            result = addCombinations(result, letters);
        }
        return result;
    }

    private ArrayList<String> addCombinations(ArrayList<String> input, String[] letters) {
        if (input.isEmpty()) {
            return Arrays.stream(letters).collect(Collectors.toCollection(ArrayList::new));
        }
        return input.stream()
                .flatMap(current -> Arrays.stream(letters).map(letter -> current + letter))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
