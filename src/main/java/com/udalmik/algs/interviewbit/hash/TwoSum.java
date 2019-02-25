package com.udalmik.algs.interviewbit.hash;

import java.util.*;

public class TwoSum {

    public ArrayList<Integer> twoSum(final List<Integer> values, int n) {

        Map<Integer, List<Integer>> valueToIdx = new HashMap<>();

        for (int i = 0; i < values.size(); i++) {
            Integer value = values.get(i);
            valueToIdx.putIfAbsent(value, new ArrayList<>());
            valueToIdx.get(value).add(i);
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < values.size(); i++) {
            Integer value = values.get(i);
            List<Integer> integers = valueToIdx.get(n - value);
            if (integers != null && integers.size() > 0) {
                for (Integer secondIdx : integers) {
                    if (secondIdx > i && ((secondIdx < second) || (secondIdx == second && i < first))) {
                        second = secondIdx;
                        first = i;
                    }
                }
            }
        }

        return Integer.MAX_VALUE == first ? new ArrayList<>() : new ArrayList<>(Arrays.asList(first + 1, second + 1));

    }

}
