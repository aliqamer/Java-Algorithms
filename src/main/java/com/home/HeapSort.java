package com.home;

/**
 * Created by Ali on 10/1/2016.
 */
public class HeapSort {

    public static void main(String args[]){
        HeapSort obj = new HeapSort();
        int[] a = new int[] {10,12,15,30,18,5,20};
        obj.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]+" ");
        }
    }

    private void sort(int[] a) {
        int n = a.length;
        for (int i = n /2-1; i>=0; i--) {
            heapify(a,i, n);
        }

        for(int i=n-1; i>=0; i--){
            swap(a, 0, i);
            heapify(a, 0, i);
        }
    }

    private void heapify(int[] a, int i, int n) {

        int max = i;
        int L = (i<<1) + 1;
        int R = L + 1;

        if(L<n && a[L] > a[i]){
            max = L;
        }
        if(R<n && a[R] > a[max]){
            max = R;
        }
        if(i != max) {
            swap(a,i,max);
            heapify(a, max, n);
        }
    }

    private void swap(int[] a, int p, int q) {
        int temp = a[p];
        a[p] = a[q];
        a[q] = temp;
    }
}
