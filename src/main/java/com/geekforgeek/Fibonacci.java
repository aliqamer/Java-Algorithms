package com.geekforgeek;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ali on 11/10/2016.
 */
public class Fibonacci {

    public static void main(String args[]) {


        Fibonacci object = new Fibonacci();


        int n = 9;
        System.out.println(object.find(n));

        int[] memo = new int[n+1];
        System.out.println(object.fib(n, memo));

        List<int[]> ints = Arrays.asList(memo);
    }

    private int fib(int n, int[] memo) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        if(memo[n] == 0){
            memo[n] = fib(n-1, memo) + fib(n-2, memo);
        }
        return memo[n];
    }

    private int find(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        return find(n-1) + find(n-2);

    }
}
