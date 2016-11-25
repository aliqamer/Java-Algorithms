package com.geekforgeek;

import java.util.Scanner;

/**
 * Created by Ali on 11/12/2016.
 * Partition a set into two subsets such that the difference of subset sums is minimum
 Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.

 If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

 Example:

 Input:  arr[] = {1, 6, 11, 5}
 Output: 1
 Explanation:
 Subset1 = {1, 5, 6}, sum of Subset1 = 12
 Subset2 = {11}, sum of Subset2 = 11
 http://www.practice.geeksforgeeks.org/problem-page.php?pid=166
 *
 *
 */
public class MinimumDiffSubSet {

    public static void main(String args[]) {


        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] res = new int[t];
        int i=0;
        int n;
        while(t-->0){
            n = sc.nextInt();
            int[] a = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            res[i++] = getSubSum(a);
        }
        for(int k=0; k<res.length;k++){
            System.out.println(res[k]);
        }
    }

    private static int getSubSum(int[] a) {

        int sum = a[0];
        for (int i = 1; i < a.length; i++) {
            sum += a[i];
        }

        return findMinDiff(a,a.length-1,0,sum);
    }

    private static int findMinDiff(int[] a, int n, int currSum, int totalSum) {

        if(n == 0){
            return Math.abs((totalSum - currSum) - currSum);
        }

        return Math.min(findMinDiff(a,n-1, currSum+a[n-1],totalSum),
                        findMinDiff(a,n-1,currSum,totalSum));
    }
}
