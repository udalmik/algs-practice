package com.udalmik.algs.interviewbit.stackqueue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/nearest-smaller-element/
 */
public class NearestSmallerElement {

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> nums) {

        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i);
            while (!stack.isEmpty() && stack.peek() >= val) {
                stack.pop();
            }
            int resNum = stack.isEmpty() ? -1 : stack.peek();
            stack.push(val);
            res.add(resNum);
        }

        return res;

    }

}
