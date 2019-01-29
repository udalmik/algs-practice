package com.udalmik.algs.interviewbit.math;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.interviewbit.com/problems/excel-column-number/
 */
public class ExcelColumnNumber {

    static class Num {
        char code;
        int value;
        public Num(char code, int value) {
            this.code = code;
            this.value = value;
        }

        public char getCode() {
            return code;
        }

        public int getValue() {
            return value;
        }
    }

    public int titleToNumber(String title) {
        AtomicInteger counter = new AtomicInteger(1);
        Map<Character, Num> dic = IntStream.rangeClosed('A', 'Z')
                .mapToObj(intCode -> new Num((char) intCode, counter.getAndIncrement()))
                .collect(Collectors.toMap(Num::getCode, Function.identity()));

        int result = 0;
        char[] chars = title.toUpperCase().toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            int power = chars.length - 1 - i;
            result += (Math.pow(dic.size(), power) * dic.get(chars[i]).getValue());
        }

        return result;

    }

}
