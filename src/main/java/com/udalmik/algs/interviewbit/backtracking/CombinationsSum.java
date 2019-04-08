package com.udalmik.algs.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/*
 * https://www.interviewbit.com/problems/combination-sum/
 */
public class CombinationsSum {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> nums, int sum) {
        Collections.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        addCombinations(0,0, new ArrayList<>(), result, sum, nums);
        return result.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
    }

    private void addCombinations(int index, int currentSum, ArrayList<Integer> currentCombination, ArrayList<ArrayList<Integer>> result, int sum,  ArrayList<Integer> nums) {
        if (currentSum == sum) {
            result.add(currentCombination);
            return;
        }
        if (currentSum > sum) {
            return;
        }
        for (int i = index; i < nums.size(); i++) {
            ArrayList<Integer> copy = new ArrayList<>(currentCombination);
            copy.add(nums.get(i));
            addCombinations(i, currentSum + nums.get(i), copy, result, sum, nums);
        }
    }

}
