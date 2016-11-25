package com.home;

import java.util.Scanner;

/**
 * Created by Ali on 9/29/2016.
 *
 * input: 5 4
 1 2 3 4 5
 output : 5 1 2 3 4

 */
public class RotateArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        while(k-->0) {
            int first = a[0];
            for(int i=0;i<n-1;i++){
                a[i] = a[i+1];
            }
            a[n-1] = first;
        }

        for(int a_i=0; a_i < n; a_i++){
            System.out.print(a[a_i]+" ");
        }
    }
}
