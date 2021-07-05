package com.foxminded;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void getDivisionListTestOne() {

        ArrayList<Integer> list =  new ArrayList<>();
        int[] arr = {38, 36, 29, 28, 14, 12, 25, 24, 1};
        for (int value : arr) {
            list.add(value);
        }

        Result expected = new Result(78945,4,19736, list);

        Result actual = calculator.divide(78945, 4);
        assertEquals(expected, actual);
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
            assertEquals(integer, actual.getIntermediateResults().remove(0));
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
