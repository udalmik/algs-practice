package com.udalmik.algs.interviewbit.math;

/**
 * https://www.interviewbit.com/problems/palindrome-integer/
 */
public class PalindromeInteger {

    // (!) Do this without extra space
    public int isPalindrome(int num) {

        if (num < 0) return 0;
        if (num == 0 || num < 10) return 1;

        int digits = 0;
        int temp = num;
        while (temp != 0) {
            digits++;
            temp /= 10;
        }

        int left = digits;
        int right = 1;

        while (left > right) {
            int leftValue = byIndex(num, left);
            int rightValue = byIndex(num, right);
            if (leftValue != rightValue)
                return 0;
            left--;
            right++;
        }

        return 1;

    }

    public int byIndex(int num, int index) {
        if (index == 1)
            return num % 10;
        num /= Math.pow(10, index - 1);
        return num % 10;
    }
}
