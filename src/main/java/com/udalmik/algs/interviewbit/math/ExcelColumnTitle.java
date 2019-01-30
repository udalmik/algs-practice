package com.udalmik.algs.interviewbit.math;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExcelColumnTitle {

    static class Num {
        char code;
        int value;
        public Num(char code, int value) {
            this.code = code;
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public String convertToTitle(int A) {

        if (A == 0) return "0";

        AtomicInteger counter = new AtomicInteger(1);
        Map<Integer, Num> dic = IntStream.rangeClosed('A', 'Z')
                .mapToObj(intCode -> new Num((char) intCode, counter.getAndIncrement()))
                .collect(Collectors.toMap(Num::getValue, Function.identity()));

        StringBuilder res = new StringBuilder();

        if (A <= dic.size()) {
            return String.valueOf(dic.get(A).code);
        }

        while (A > 0) {
            int key = A % dic.size();
            if (key == 0) {
                res.append("Z");
                A = A / dic.size() - 1;
            } else {
                res.append(dic.get(key).code);
                A /= dic.size();
            }
        }

        return res.reverse().toString();

    }


}
