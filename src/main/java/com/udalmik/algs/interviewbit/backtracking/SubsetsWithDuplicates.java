package com.udalmik.algs.interviewbit.backtracking;

import java.util.*;

/**
 * https://www.interviewbit.com/problems/subsets-ii/
 */
public class SubsetsWithDuplicates {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> numbers) {

        LinkedHashSet<ArrayList<Integer>> result = new LinkedHashSet<>();

        result.add(new ArrayList<>());

        if (numbers.isEmpty()) {
            return new ArrayList<>(result);
        }

        Collections.sort(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            Integer num = numbers.get(i);
            List<Integer> restNumbers = i < numbers.size() - 1 ? numbers.subList(i + 1, numbers.size()) : Collections.emptyList();
            generateSubsets(new ArrayList<>(Collections.singletonList(num)), restNumbers, result);
        }

        return new ArrayList<>(result);


    }

    private void generateSubsets(ArrayList<Integer> current, List<Integer> restNumbers, LinkedHashSet<ArrayList<Integer>> result) {

        if (!result.contains(current)) {
            result.add(current);
        }
        if (restNumbers.isEmpty()) {
            return;
        }

        Integer nextValue = restNumbers.get(0);
        restNumbers = restNumbers.size() > 1 ? restNumbers.subList(1, restNumbers.size()) : Collections.emptyList();

        // with next
        ArrayList<Integer> first = new ArrayList<>(current);
        first.add(nextValue);
        generateSubsets(first, restNumbers, result);

        // with skipped next
        ArrayList<Integer> second = new ArrayList<>(current);
        generateSubsets(second, restNumbers, result);

    }

}
