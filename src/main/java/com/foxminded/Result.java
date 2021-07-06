package com.foxminded;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Result {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return intermediateResults.equals(result.intermediateResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intermediateResults);
    }

    private final int dividend;
    private final int divider;
    private final int resultOfCalculations;
    private final List<Integer> intermediateResults;

    public int getDividend() {
        return dividend;
    }

    public int getDivider() {
        return divider;
    }

    public int getResultOfCalculations() {
        return resultOfCalculations;
    }

    public List<Integer> getIntermediateResults() {
        return intermediateResults;
    }

    public Result(int dividend, int divider, int resultOfCalculations, List<Integer> integerArrayList) {
        this.dividend = dividend;
        this.divider = divider;
        this.resultOfCalculations = resultOfCalculations;
        this.intermediateResults = integerArrayList;
    }
}
