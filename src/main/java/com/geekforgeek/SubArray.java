package com.geekforgeek;

import java.util.ArrayList;

/*
Given an unsorted array A of size N that contains only non-negative integers, find a continuous sub-array which adds to a given number S.

https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
 */
public class SubArray {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,7,5}; 5 , 12
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        ArrayList<Integer> subarraySum = subarraySum(arr, 10, 15);
        System.out.println(subarraySum);
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        if(n < 1) {
            result.add(-1);
            return result;
        }
        int sum = 0;
        int start = 0;
        for(int i=0; i<n; i++) {
            sum += arr[i];
            if(sum == s) {
                result.add(start+1);
                result.add(i+1);
                return result;
            } else if (sum < s) {
                continue;
            } else {
                while(sum > s) {
                    sum -= arr[start++];
                }
                if(sum == s) {
                    result.add(start+1);
                    result.add(i+1);
                    return result;
                }
            }
        }
        result.add(-1);
        return result;
    }
}
