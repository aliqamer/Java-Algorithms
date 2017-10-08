package com.desginpattern.chainofresponsibililty;

public class TestCalcChain {

    public static void main(String args[]) {

        Chain chainCal1 = new AddNumbers();
        Chain chainCal2 = new SubtractNumbers();
        Chain chainCal3 = new MultiplyNumbers();

        chainCal1.setNextChain(chainCal2);
        chainCal2.setNextChain(chainCal3);

        Numbers numbers = new Numbers(4, 6, "mul");

        chainCal1.calculate(numbers);
    }
}
