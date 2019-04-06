package com.udalmik.algs.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Permutations {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> values) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (Integer value : values) {
            result = permute(result, value);
        }
        return result;
    }

    private ArrayList<ArrayList<Integer>> permute(ArrayList<ArrayList<Integer>> current, int number) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (current.isEmpty()) {
            ArrayList<Integer> integers = new ArrayList<>(Collections.singletonList(number));
            result.add(integers);
            return result;
        }
        for (ArrayList<Integer> integers : current) {
            for (int i = 0; i < integers.size(); i++) {
                ArrayList<Integer> copy = new ArrayList<>(integers);
                copy.add(i, number);
                result.add(copy);
            }
            ArrayList<Integer> copy = new ArrayList<>(integers);
            copy.add(number);
            result.add(copy);
        }
        return result;
    }

}
