package com.geekforgeek;

import java.util.Scanner;

/**
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=134
 * Given a sequence, find the length of the longest subsequence of a given sequence .
 The longest increasing subsequence means to find a subsequence of a given sequence in which
 the subsequence's elements are in sorted order, lowest
 to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.

 For example:
 length of LIS for
 { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 //        int[] a = {5,3,4,2,7,9}; // 3 4 7 9
 int[] a = {8, 22, 9, 33, 21, 50, 41, 60, 80 };
 //        int[] a = {8,22,9,12};
 //        int[] a = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13 ,3, 11, 7, 15};
 //        int[] a = {10, 22, 9, 33, 21, 50, 41, 60,80};
 * Created by Ali on 11/1/2016.
 */
public class LongestIncreasingSubsequence {

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
            res[i++] = findLongestSequence(a);
        }
        for(int k=0; k<res.length;k++){
            System.out.println(res[k]);
        }
    }

    private static int findLongestSequence(int[] a) {

        int max = 1;
        int[] s = new int[a.length];
        s[0] = 1;
        for (int i = 1; i < a.length; i++) {
            max = getLastMax(a, max, s, i);
        }
        return max;
    }

    private static int getLastMax(int[] a, int max, int[] s, int i) {
        int j = i-1;
        int tempMax=0, index = -1;
        while(j>=0){
            if(a[j] < a[i]){
                if(tempMax < s[j]){
                    tempMax = s[j];
                    index = j;
                }
            }
            j--;
        }
        if(index == -1){
            s[i] = 1;
        }else{
            s[i] = s[index]+1;
            max = Math.max(s[i], max);
        }
        return max;
    }
}
