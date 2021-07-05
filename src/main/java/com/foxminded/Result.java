package com.foxminded;

import java.util.ArrayList;
import java.util.Deque;

public final class Result {
    private final int dividend;
    private final int divider;
    private final int resultOfCalculations;
    private final ArrayList<Integer> intermediateResults;

    public int getDividend() {
        return dividend;
    }

    public int getDivider() {
        return divider;
    }

    public int getResultOfCalculations() {
        return resultOfCalculations;
    }

    public ArrayList<Integer> getIntermediateResults() {
        return intermediateResults;
    }

    public Result(int dividend, int divider, int resultOfCalculations, ArrayList<Integer> integerArrayList) {
        this.dividend = dividend;
        this.divider = divider;
        this.resultOfCalculations = resultOfCalculations;
        this.intermediateResults = integerArrayList;
    }
}
