package com.foxminded;

import java.util.*;

public class Calculator {

    public Result divide(int dividend, int divider) {
        if (divider == 0){
            throw new ArithmeticException("Division by zero!");
        }
        int result = dividend / divider;
        ArrayList<Integer> divisionList = getDivisionList(dividend, divider, result);

        return new Result(dividend, divider, result, divisionList);

    }

    protected ArrayList<Integer> getDivisionList(int dividend, int divider, int result) {
        ArrayList<Integer> integers = new ArrayList<>();
        int remain = dividend % divider;
        if (dividend < divider){
            integers.add(remain);
            integers.add(result * divider);
            return integers;
        }
        integers.add(remain);

        while (result > 0) {
            int lastDigit = result % 10;
            if (lastDigit == 0) {
                result /= 10;
                continue;
            }
            int multi = lastDigit * divider;
            integers.add(multi);
            integers.add(multi + remain);
            dividend /= 10;
            remain = dividend % divider;
            result /= 10;
        }
        integers.remove(integers.size()-1);
        Collections.reverse(integers);
        return integers;
    }
}
