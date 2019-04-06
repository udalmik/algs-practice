package com.udalmik.algs.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/combinations/
 */
public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= n - k + 1; i++) {
            collectSubset(new ArrayList<>(Collections.singletonList(i)), k, n, i + 1, result);
        }
        return result;
    }

    private void collectSubset(ArrayList<Integer> current, int k, int n, int nextNum, ArrayList<ArrayList<Integer>> result) {
        if (current.size() == k) {
            result.add(current);
            return;
        }
        if (nextNum > n) {
            return;
        }
        if (current.size() > k) {
            return;
        }
        // add next num to set
        {
            ArrayList<Integer> copy = new ArrayList<>(current);
            copy.add(nextNum);
            collectSubset(copy, k, n,nextNum + 1, result);
        }
        // skip next and try with other one
        {
            collectSubset(new ArrayList<>(current), k, n, nextNum + 1, result);
        }
    }

}
