package com.foxminded;

import java.util.StringJoiner;

public class Formatter {

    private Result result;

    public String format(Result result) {
        this.result = result;
        StringJoiner outputString = new StringJoiner("");
        outputString.add("_" + result.getDividend() + "|" + result.getDivider() + "\n");

        int countOfDigitsInDividend = getCountOfDigits(result.getDividend());
        int countOfDigitsInPeek = getCountOfDigits(getPeekNumber());
        int countOfSpaces = countOfDigitsInDividend - countOfDigitsInPeek;
        int countOfDigitsInResult = getCountOfDigits(result.getResultOfCalculations());

        outputString.add(" " + result.getIntermediateResults().get(0) + repeatSymbol(countOfSpaces, " ")
                + "|" + repeatSymbol(countOfDigitsInResult, "-") + "\n");

        result.getIntermediateResults().remove(0);

        outputString.add(" " + repeatSymbol(countOfDigitsInDividend - countOfSpaces, "-") + repeatSymbol(countOfSpaces, " ")
                + "|" + result.getResultOfCalculations() + "\n");

        outputString.add(displayCalculatingResult(countOfDigitsInPeek));
        return outputString.toString();
    }

    private String displayCalculatingResult(int countOfDigitsInPrevious) {
        StringJoiner joiner = new StringJoiner("");
        int countOfDigits = getCountOfDigits(getPeekNumber());
        int numberOfSort = countOfDigitsInPrevious + 1;
        int i = 0;
        while (result.getIntermediateResults().size() > 1) {
            numberOfSort++;
            int countOfSpaces = numberOfSort - countOfDigits;

            joiner.add(repeatSymbol(countOfSpaces - 1, " ") + "_" + result.getIntermediateResults().get(i) + "\n");
            result.getIntermediateResults().remove(i);
            joiner.add(repeatSymbol(countOfSpaces, " ") + result.getIntermediateResults().get(i) + "\n");
            result.getIntermediateResults().remove(i);
            joiner.add(repeatSymbol(countOfSpaces, " ") + repeatSymbol(countOfDigits, "-") + "\n");

            countOfDigits = getCountOfDigits(getPeekNumber());
        }
        joiner.add(repeatSymbol(numberOfSort - getCountOfDigits(getPeekNumber()), " ") + result.getIntermediateResults().remove(0));
        return joiner.toString();
    }

    protected String repeatSymbol(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

    protected int getCountOfDigits(int number){
        if (number == 0){
            return 1;
        }
        return (int)Math.log10(number) + 1;
    }

    protected int getPeekNumber(){
        if(!result.getIntermediateResults().isEmpty()){
            return result.getIntermediateResults().get(0);
        }else{
            throw new NullPointerException("List is empty!");
        }
    }
}
