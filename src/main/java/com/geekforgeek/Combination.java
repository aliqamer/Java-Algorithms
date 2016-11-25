package com.geekforgeek;

/**
 * Created by Ali on 10/30/2016.
 */
public class Combination {
    static String[] b = {"A","B","C","D"};


    public static void main(String args[]) {

        int[] a = {0,0,0,0};
        comb(a,0,3);
    }

    private static void comb(int[] a, int k, int n) {

        if(k == n){
            a[k] = 0;
            printB(a,n);
            a[k] = 1;
            printB(a,n);
            return;
        }
        a[k] = 0;
        comb(a,k+1,n);
        a[k] = 1;
        comb(a,k+1,n);
    }

    private static void printB(int[] a, int n) {
        boolean flg = true;
        for (int i = 0; i <= n; i++) {
            if(a[i] == 1){
                System.out.print(b[i]);
                flg = false;
            }
        }
        if(flg){
            System.out.print("null set");
        }
        System.out.println("");
    }
}
