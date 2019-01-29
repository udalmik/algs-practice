package com.udalmik.algs.interviewbit.math;

public class GreatestCommonDivisor {

    public int gcd(int a, int b) {

        int max = Math.max(a, b);

        for (int i = max; i > 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }

        return 1;
    }
}
