package com.udalmik.algs.interviewbit.math;

public class DecToBinary {

    public String findDigitsInBinary(int n) {

        if (n == 0) return "0";

        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            sb.append(n % 2);
            n /= 2;
        }

        return sb.reverse().toString();

    }


}
