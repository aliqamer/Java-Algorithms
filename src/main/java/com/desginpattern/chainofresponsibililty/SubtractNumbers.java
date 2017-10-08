package com.desginpattern.chainofresponsibililty;

public class SubtractNumbers implements Chain {

    private Chain nextChain;


    @Override
    public void setNextChain(Chain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void calculate(Numbers request) {

        if(request.getCalculationWanted() == "sub"){
            System.out.println(request.getNumber1() + " - " + request.getNumber2() + " = " + (
                    request.getNumber1() - request.getNumber2()));
        }else {

            nextChain.calculate(request);
        }
    }
}
