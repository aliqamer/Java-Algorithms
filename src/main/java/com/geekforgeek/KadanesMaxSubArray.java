package com.geekforgeek;

/*
https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
Given an array arr of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.
 */
public class KadanesMaxSubArray {
    public static void main(String[] args) {
//        int[] arr = {-2, 1, -2, 4, 3, 5, 1, -5, 4,-7, -8, 10, 5};
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        int global_max = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            max = Math.max(arr[i], max+arr[i]);

            if(global_max < max) {
                global_max = max;
            }
        }
        System.out.println(global_max);
    }
}
