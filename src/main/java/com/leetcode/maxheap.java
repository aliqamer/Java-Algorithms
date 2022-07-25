package com.leetcode;

public class maxheap {
    public static void main(String[] args) {
        int[] a = {4,8,1,9,7,2,5,3};
        getMaxHeap(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }

        for (int i = a.length-1; i > 0; i--) {
            swap(a,0,i);
            heapify(a,0,i);
        }

        System.out.println("");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    private static void getMaxHeap(int[] a) {

        int n = a.length;
        for (int i = n/2-1; i >=0; i--) {
            heapify(a,i,n);
        }
    }

    private static void heapify(int[] a, int i, int n) {
        int max = i;
        int l = 2*i+1;
        int r = l+1;

        if(l<n && a[l] > a[max]){
            max = l;
        }
        if(r<n && a[r] > a[max]){
            max = r;
        }
        if(i != max){
            swap(a,i,max);
            heapify(a, max, n);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
