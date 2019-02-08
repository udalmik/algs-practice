package com.udalmik.algs.interviewbit.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LargestContinuousZeroSum {

    class IndexedSum {
        int sum;
        int idx;

        public IndexedSum(int sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }

        public int getSum() {
            return sum;
        }
    }

    public ArrayList<Integer> lszero(ArrayList<Integer> values) {

        int total = 0;

        List<IndexedSum> indexedSums = new ArrayList<>();

        for (int i = 0; i < values.size(); i++) {
            Integer value = values.get(i);
            total += value;
            indexedSums.add(new IndexedSum(total, i));
        }

        Map<Integer, List<IndexedSum>> collected = indexedSums.stream()
                .collect(Collectors.groupingBy(IndexedSum::getSum));

        collected.computeIfPresent(0, (v, list) -> {
                ArrayList<IndexedSum> newList = new ArrayList<>();
                newList.add(new IndexedSum(0, -1));
                newList.addAll(list);
                return newList;
        });

        int max = 0;
        int begin = -1;
        int end = -1;

        for (Map.Entry<Integer, List<IndexedSum>> integerListEntry : collected.entrySet()) {
            List<IndexedSum> indices = integerListEntry.getValue();
            if (indices.size() > 1) {
                IndexedSum first = indices.get(0);
                IndexedSum second = indices.get(indices.size() - 1);
                int rangeLength = second.idx - first.idx;
                if (rangeLength > max || (rangeLength == max && first.idx + 1 < begin)) {
                    max = rangeLength;
                    begin = first.idx + 1;
                    end = second.idx;
                }
            }
        }

        return begin > -1 ? new ArrayList<>(values.subList(begin, end + 1)) : new ArrayList<>();

    }
}

