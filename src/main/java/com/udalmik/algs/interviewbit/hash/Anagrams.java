package com.udalmik.algs.interviewbit.hash;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Anagrams {

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> strings) {

        Map<String, ArrayList<Integer>> buckets = new LinkedHashMap<>();

        IntStream
                .range(0, strings.size())
                .forEach(i -> {
                    String s = strings.get(i);
                    String sortedS = s.chars().sorted()
                            .mapToObj(c -> String.valueOf((char) c))
                            .collect(Collectors.joining());
                    buckets.computeIfAbsent(sortedS, v -> new ArrayList<>());
                    buckets.get(sortedS).add(i + 1);
                });

        return new ArrayList<>(buckets.values());


    }
}
