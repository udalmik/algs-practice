package com.udalmik.algs.interviewbit.math;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/rearrange-array/
 */
public class RearrangeArray {

    public void arrange(ArrayList<Integer> values) {

        for (int i = 0; i < values.size(); i++) {
            Integer value = values.get(i);
            Integer lowBits = getLowBits(value);
            Integer newValue = values.get(lowBits);
            values.set(i, setHighBits(value, newValue));
        }

        for (int i = 0; i < values.size(); i++) {
            Integer value = values.get(i);
            values.set(i, shiftRight(value));
        }
    }

    private Integer shiftRight(Integer value) {
        return value >>> 16;
    }

    private Integer setHighBits(Integer value, Integer newValue) {
        return value | (newValue << 16);
    }

    private Integer getLowBits(Integer value) {
        return value & (-1 >>> 16);
    }

}
