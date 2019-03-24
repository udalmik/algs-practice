package com.udalmik.algs.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/subset/
 */
public class Subsets {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> values) {
        Collections.sort(values);
        return getSubsets(new ArrayList<>(), values);
    }

    private ArrayList<ArrayList<Integer>> getSubsets(List<Integer> currentSet, List<Integer> restItems) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(currentSet));

        if (!restItems.isEmpty()) {
            for (int i = 0; i < restItems.size(); i++) {
                Integer value = restItems.get(i);
                ArrayList<Integer> currentSetCopy = new ArrayList<>(currentSet);
                currentSetCopy.add(value);
                List<Integer> rest = i + 1 < restItems.size() ? restItems.subList(i + 1, restItems.size()) : new ArrayList<>();
                result.addAll(getSubsets(currentSetCopy, rest));
            }
        }

        return result;
    }
}
