package com.foxminded;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    public Result divide(int dividend, int divider) {
        if (divider == 0){
            throw new ArithmeticException("Division by zero!");
        }
        int result = dividend / divider;
        Deque<Integer> stack = getDivisionList(dividend, divider, result);

        return new Result(dividend, divider, result, stack);

    }

    protected Deque<Integer> getDivisionList(int dividend, int divider, int result) {
        Deque<Integer> stack = new ArrayDeque<>();
        int remain = dividend % divider;
        if (dividend < divider){
            stack.push(remain);
            stack.push(result * divider);
            return stack;
        }
        stack.push(remain);

        while (result > 0) {
            int lastDigit = result % 10;
            int multi = lastDigit * divider;
            stack.push(multi);
            stack.push(multi + remain);
            dividend /= 10;
            remain = dividend % divider;
            result /= 10;
        }
        stack.pop();

        return stack;
    }
}
