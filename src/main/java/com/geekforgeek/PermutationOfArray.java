package com.geekforgeek;

/**
 * Created by Ali on 10/30/2016.
 */
public class PermutationOfArray {

    public static void main(String args[]) {

        PermutationOfArray object = new PermutationOfArray();

        int[] a = {1,2,3,4};
        permutation(a, 0, 4);
    }

    private static void permutation(int[] a, int k, int n) {
        if(n == k){
            for (int i = 0; i < n; i++) {
                System.out.print(a[i]);
            }
            System.out.println("");
        }
        else {
            for (int i = k; i < n; i++) {
                swap(a, i, k);
                permutation(a, k + 1, n);
                swap(a, i, k);
            }
        }
    }

    private static void swap(int[] a, int i, int k) {
        int t = a[i];
        a[i] = a[k];
        a[k] = t;
    }
}
