package com.udalmik.algs.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class GenerateParenthesis {

    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        generateParenthesisInternal(n, 0, 0, "", result);
        Collections.sort(result);
        return result;
    }

    private void generateParenthesisInternal(int n, int left, int right, String current, ArrayList<String> result) {
        if (current.length() > n * 2) {
            return;
        }
        if (current.length() == n * 2 && left == right) {
            result.add(current);
        }
        if (left < n) {
            generateParenthesisInternal(n, left + 1, right, current + "(", result);
        }
        if (right < left) {
            generateParenthesisInternal(n, left, right + 1, current + ")", result);
        }
    }

}
