package com.recursion;

public class Power {

    public static void main(String args[]) {

        Power object = new Power();

        System.out.println(object.pow(10,3));

    }

    private long pow(int x, int n) {

        if(n == 0){
            return 1;
        } else if(n == 1){
            return x;
        } else if(x == 0){
            return 0;
        }

        long temp = pow(x, n/2);

        if(n%2 == 0){
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }
}
