package com.udalmik.algs.interviewbit.math;

public class ReverseInteger {

    public int reverse(int A) {

        long result = 0;
        boolean negative = A < 0;
        A = Math.abs(A);
        int aLength = digitsNum(A);

        for (int i = aLength; i > 0; i--) {
            result += byIndex(A, aLength - i + 1) * Math.pow(10, i - 1);
        }

        long longRes = negative ? -result : result;
        if (result < 0 && result < Integer.MIN_VALUE) {
            return 0;
        }
        if (result > 0 && result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) longRes;

    }

    public int byIndex(int num, int index) {
        if (index == 1)
            return num % 10;
        num /= Math.pow(10, index - 1);
        return num % 10;
    }

    private int digitsNum(int a) {
        int counter = 0;
        do {
            counter++;
            a /= 10;
        } while (a != 0);
        return counter;
    }

}
