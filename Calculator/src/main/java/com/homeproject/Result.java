package com.homeproject;

import java.util.Deque;

public final class Result {
    private final int dividend;
    private final int divider;
    private final int resultOfCalculations;
    private final Deque<Integer> intermediateResults;

    public int getDividend() {
        return dividend;
    }

    public int getDivider() {
        return divider;
    }

    public int getResultOfCalculations() {
        return resultOfCalculations;
    }

    public Deque<Integer> getIntermediateResults() {
        return intermediateResults;
    }

    public Result(int dividend, int divider, int resultOfCalculations, Deque<Integer> stack) {
        this.dividend = dividend;
        this.divider = divider;
        this.resultOfCalculations = resultOfCalculations;
        this.intermediateResults = stack;
    }
}
