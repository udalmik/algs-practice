package com.udalmik.algs.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.interviewbit.com/problems/max-continuous-series-of-1s/
 */
public class MaxContinuous1 {


    public ArrayList<Integer> maxone(final ArrayList<Integer> list,
                                     final int flipsCount) {

        int maxRange = Integer.MIN_VALUE;
        int maxRangeStart = 0;

        int start = 0;
        int end = 0;
        int currentZerosCount = 0;

        int size = list.size();

        for (int i = 0; i < size; i++) {
            Integer value = list.get(i);
            if (value == 1) {
                end = i;
            } else if (value == 0 && currentZerosCount < flipsCount) {
                currentZerosCount++;
                end = i;
            } else {
                // one more zero and no flips left
                final int currentRange = end - start + 1;
                if (currentRange > maxRange) {
                    maxRange = currentRange;
                    maxRangeStart = start;
                }

                // find new start
                do {
                    start++;
                } while (zerosInRange(start, end, list) > flipsCount && start < size);

                currentZerosCount = 0;
                i = start - 1;
            }

        }

        final int currentRange = end - start + 1;
        if (currentRange > maxRange) {
            maxRange = currentRange;
            maxRangeStart = start;
        }

        return IntStream.range(maxRangeStart, maxRangeStart + maxRange)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

    }

    private int zerosInRange(int start, int end, ArrayList<Integer> list) {
        int res = 0;
        for (int i = start; i < end; i++) {
            if (list.get(i) == 0) res++;
        }
        return res;
    }


}
