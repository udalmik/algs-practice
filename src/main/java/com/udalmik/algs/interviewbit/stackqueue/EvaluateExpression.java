package com.udalmik.algs.interviewbit.stackqueue;


import java.util.ArrayList;
import java.util.Stack;

/*
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateExpression {

    public int evalRPN(ArrayList<String> tokens) {

        Stack<Integer> operands = new Stack<>();

        tokens.forEach(token -> {
            switch (token) {
                case "+":
                    operands.push(operands.pop() + operands.pop());
                    break;
                case "-": {
                    Integer first = operands.pop();
                    Integer second = operands.pop();
                    operands.push(second - first);

                }
                break;
                case "*":
                    operands.push(operands.pop() * operands.pop());
                    break;
                case "/": {
                    Integer first = operands.pop();
                    Integer second = operands.pop();
                    operands.push(second / first);

                }
                break;
                default:
                    operands.push(Integer.parseInt(token));
            }
        });

        return operands.pop();

    }

}
