package com.geekforgeek;

import java.util.Scanner;

/**
 * Created by Ali on 10/23/2016.
 * Given two function, one is h(x) which includes the products of all the number in an array A[ ]
 * having size N and another function f(x) which denotes the GCD of all the numbers in an array.
 * Your task is to find the value of  h(x)f(x).

 Note: Since the answer can be very large, use modulo 10^9+7.

 Input:

 The first line will give the test cases,T . Then T test cases follow . Each test case contains two lines. The first line of each test case contains an integer N denoting the no of test cases. The Next line will contains N space separated values Ai .


 Output:

 Print the required answer in a new line

 Constraints:

 1<=T<=26
 1<=N<=60
 1<=Ai<=104


 Example:

 Input:
 1
 2
 2 4
 Output:
 64

 Explanation:

 Product of the elements is 8 and GCD of the elements is 2. So 8^2=64.
 */
public class MagicNumberGCD {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        double[] res = new double[t];
        int i=0;
        int n;
        while(t-->0){
            n = sc.nextInt();
            int[] a = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            res[i++] = findGcd(a);
        }
        for(int k=0; k<res.length;k++){
            System.out.println(res[k]);
        }
    }

    private static double findGcd(int[] a) {
        int gcd;
        if(a.length<1){
            return 0;
        }else{
            gcd = a[0];
        }

        int prod = a[0];
        for (int i = 1; i < a.length; i++) {
            gcd = getGcd(gcd, a[i]);
            prod = prod * a[i];
        }
        if(gcd == 0){
            return 1;
        }
        double res=1;
        while(gcd-->0){
            res = res*prod;
        }
        return res;
    }


    private static int findGcd(int n1, int n2){

        if(n1 == n2){
            return n1;
        }
        else if(n1>n2){
            return findGcd(n1-n2,n2);
        }else{
            return findGcd(n1,n2-n1);
        }
    }

    private static int getGcd(int n1, int n2) {

        if(n1 == 0 || n2 == 0){
            return 0;
        }
        if(n1 == n2){
            return n1;
        }
        int i;
        if(n1<n2){
            i = n1;
        }else{
            i = n2;
        }
        for (; i > 0; i--) {
            if(n1%i==0 && n2%i==0){
                break;
            }
        }
        return i;
    }
}
