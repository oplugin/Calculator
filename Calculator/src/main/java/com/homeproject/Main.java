package com.homeproject;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Result result = calculator.divide(78945, 4);
        Formatter formatter = new Formatter();
        String output = formatter.format(result);
        System.out.println(output);
    }
}
