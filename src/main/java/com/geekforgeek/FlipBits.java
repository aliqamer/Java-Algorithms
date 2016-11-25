package com.geekforgeek;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Ali on 10/22/2016.
 * Given an array arr[] consisting of 0’s and 1’s. A flip operation is one in which you turn 1 into 0 and a 0 into 1.You have to do
 * atmost one “Flip” operation on a subarray. Then finally display maximum number of 1 you can have in the array.
 Input:

 First line of input consist of a single integer T denoting the total number of test case.
 First line of test case contains an integer N.Second line of test case contains N space
 separated integers denoting the array arr[].

 Output:
 For each test case output a single integer representing  the maximum number of 1's
 you can have in the array after atmost one flip operation.

 Constraints:
 1<=T=100
 1<=N<=10000
 a[i]={0,1}

 Example:

 Input:

 1
 5
 1 0 0 1 0

 Output:
 4
 Explanation:
 We can perform a flip operation in the range [1,2]
 After flip operation array is : 1 1 1 1 0
 */
public class FlipBits {

    public static void main(String args[]) {

        FlipBits object = new FlipBits();
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
            res[i++] = findMaxOneSeq(a);
        }
        for(int k=0; k<res.length;k++){
            System.out.println(res[k]);
        }


    }

    static void heapSort(int[] a){

        int n = a.length;
        for (int i = n/2-1; i > 0 ; i--) {
            heapify(a, i, n);
        }

        for (int i = 1; i < n; i++) {
            int t = a[0];
            a[0] = a[a.length - i];
            a[a.length - i] = t;
            heapify(a, 0, n);

        }

    }

    private static void heapify(int[] a, int i, int n) {

        int l = (i << 1) + 1;
        int r = l + 1;

        int max = i;

        if(l < n && a[l] > a[max] ){
            max = l;
        }
        if(r < n && a[r] > a[max] ){
            max = r;
        }

        if(max != i){
            int t = a[i];
            a[i] = a[max];
            a[max] = t;
            heapify(a, max, n);
        }
    }

    private static int findMaxOneSeq(int[] a) {
        int max = 0, count = 0, ones = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < a.length; i++) {
            if(a[i] == 1){
                ones++;
                if(st.empty()){
                    if(i > 0){
                        count = i+1;
                        max = getMax(count, max);
                    }
                    st.push(i);
                }else {
                    while(i<a.length && a[i] == 1){
                        i++;
                    }
                    i--;
                    count = i - st.pop() + 1;
                    max = getMax(count, max);
                    st.push(i);
                }
            }else if(a[i] == 0 && i == a.length-1){
                if(st.empty()){
                    max = i+1;
                }else {
                    count = i - st.pop() + 1;
                    max = getMax(count, max);
                }
            }
        }
        return ones + max - 2;
    }

    private static int getMax(int count, int max) {
        if(max < count){
            max = count;
        }
        return max;
    }
}
