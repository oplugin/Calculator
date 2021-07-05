package com.foxminded;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FormatterTest {
    Formatter formatter = new Formatter();
    @Test
    void getFormatStringTest() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(36);
        integers.add(38);
        integers.add(4);
        Result result = new Result(78, 4, 19, integers);

        String expected = "_78|4\n" + " 4 |--\n" + " - |19\n" + "_38\n" + " 36\n" + " --\n" + "  2";

        String actual = formatter.format(result);

        assertEquals(expected, actual);
    }

    @Test
    void repeatSymbolTest() {
        String actual = formatter.repeatSymbol(3, "Hello!");

        String expected = "Hello!Hello!Hello!";

        assertEquals(expected, actual);
    }

    @Test
    void getCountOfDigitsTest() {
        int actual = formatter.getCountOfDigits(123456789);

        assertEquals(9, actual);
    }

    @Test
    void getCountOfDigitZeroTest() {
        int actual = formatter.getCountOfDigits(0);

        assertEquals(1, actual);
    }

    @Test
    void tryGettingPeekOfNullTest() {
        Result result = new Result(78, 4, 19, new ArrayList<>());

        Exception ex = assertThrows(NullPointerException.class, () -> formatter.format(result), "Invalid error message.");

        assertEquals("List is empty!", ex.getMessage());
    }
}
