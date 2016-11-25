package com.geekforgeek;

/**
 * Created by Ali on 10/30/2016.
 */
public class MaxSubSequence {

    public static void main(String args[]) {

        MaxSubSequence object = new MaxSubSequence();
        int[] a = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println(findSum(a,7));
    }

    static int findSubSum(int[] a, int n){

        int s = a[0], max = a[0];
        for (int i = 1; i <= n; i++) {
            s = Math.max(s+a[i], a[i]);
            if(s > max){
                max = s;
            }
        }
        return max;
    }

    static int findSum(int[] a, int n){

        if(n == 0){
            return a[0];
        }
        int sum = findSum(a, n - 1);
        int total = Math.max(sum + a[n], a[n]);
        return Math.max(sum, total);
    }


    //kadanes algo
    private static int findSum(int[] a){
        int max=a[0], max_so_far=0;
        boolean allNegative = true;
        for (int i = 0; i < a.length; i++) {
            if(a[i] > 0){
                allNegative = false;
                break;
            }else if(a[i] > max){
                max = a[i];
            }
        }
        if(allNegative){
            return max;
        }
        for (int i = 0; i < a.length; i++) {
            max_so_far += a[i];
            if(max_so_far < 0){
                max_so_far = 0;
            }else if(max_so_far > max){
                max = max_so_far;
            }
        }
        return max;
    }
}
