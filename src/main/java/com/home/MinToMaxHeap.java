package com.home;

/**
 * Created by Ali on 10/2/2016.
 */
public class MinToMaxHeap {
    public static void main(String args[]){
        MinToMaxHeap obj = new MinToMaxHeap();
        int[] a = new int[] {3, 5, 29, 6, 8, 20, 10, 12, 18, 9};
        obj.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    private void sort(int[] a) {

        int n = a.length;
        for (int i = n/2-1; i >= 0; i--) {
            maxHeapify(a,i,n);
        }
    }

    private void maxHeapify(int[] a, int i, int n) {

        int max = i;
        int L = (i<<1)+1;
        int R = L + 1;

        if(L<n && a[L] > a[max]) {
            max = L;
        }
        if(R<n && a[R] > a[max]) {
            max = R;
        }
        if(i != max){
            swap(a,i,max);
            maxHeapify(a,max,n);
        }
    }

    private void swap(int[] a, int p, int q) {
        int temp = a[p];
        a[p] = a[q];
        a[q] = temp;
    }

}
