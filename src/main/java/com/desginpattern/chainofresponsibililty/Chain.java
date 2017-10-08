package com.desginpattern.chainofresponsibililty;

public interface Chain {

    public void setNextChain(Chain nextChain);

    public void calculate(Numbers request);

}
