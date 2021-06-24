package com.foxminded;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void getDivisionListTestOne() {
        ArrayList<Integer> expected = new ArrayList<>();
        int[] arr = {1, 24, 25, 12, 14, 28, 29, 36, 38, 4};
        for (int value : arr) {
            expected.add(value);
        }

        Collections.reverse(expected);

        Deque<Integer> actual= calculator.getDivisionList(78945, 4, 19736);

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.pop());
        }
    }

    @Test
    void getDivisionListTestTwo() {
        ArrayList<Integer> expected = new ArrayList<>();
        int[] arr = {15, 207, 222, 161, 183, 46};
        for (int value : arr) {
            expected.add(value);
        }

        Deque<Integer> actual= calculator.getDivisionList(6432, 23, 279);

        for (Integer integer : expected) {
            assertEquals(integer, actual.pop());
        }
    }

    @Test
    void dividendLessThanDividerTest() {
        int dividend = 10;
        int divider = 20;
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(10);
        expected.add(0);

        Result actual = calculator.divide(dividend, divider);
        for (Integer integer : expected) {
            assertEquals(integer, actual.getIntermediateResults().pop());
        }
    }

    @Test
    void gettingResultTest() {
        int dividend = 194320;
        int divider = 467;

        int actual = calculator.divide(dividend, divider).getResultOfCalculations();

        int expected = dividend / divider;

        assertEquals(expected, actual);
    }

    @Test
    void ArithmeticExceptionTest() {
        int dividend = 100;
        int divider = 0;

        Exception ex = assertThrows(ArithmeticException.class, () -> calculator.divide(dividend, divider), "Invalid error message.");

        assertEquals("Division by zero!", ex.getMessage());
    }
}
