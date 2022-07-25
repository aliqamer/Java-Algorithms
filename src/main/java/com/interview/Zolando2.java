package com.interview;

public class Zolando2 {

    public static void main(String[] args) {
//        int[] A =new int[] {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};
//        int[] A = new int[] {5, 8};
        int[] A =new int[] {1, 1, 1, 1};
        int sum = A[0];
        int i = 1;
        int n = A.length;
        while(i < n) {
            if(A[i] > A[i-1]) {
                sum += A[i]-A[i-1];
            }
            i++;
        }
        System.out.println(sum);
    }
}
