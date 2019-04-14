package com.udalmik.algs.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/combination-sum-ii/
 */
public class CombinationsSum2 {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> numbers, int value) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Collections.sort(numbers);

        combinationsInternal(0, new ArrayList<>(), numbers, result, value);

        return result;

    }

    private void combinationsInternal(int currentSum, ArrayList<Integer> currentCombination, ArrayList<Integer> numbers, ArrayList<ArrayList<Integer>> result, int value) {

        if (currentSum == value) {
            Collections.sort(currentCombination);
            if (!result.contains(currentCombination)) {
                result.add(currentCombination);
            }
        }

        if (currentSum > value) {
            return;
        }

        numbers.forEach(num -> {
            ArrayList<Integer> numsCopy = new ArrayList<>(numbers);
            numsCopy.remove(num);
            ArrayList<Integer> combinationCopy = new ArrayList<>(currentCombination);
            combinationCopy.add(num);
            combinationsInternal(currentSum + num, combinationCopy, numsCopy, result, value);
        });

    }

}
