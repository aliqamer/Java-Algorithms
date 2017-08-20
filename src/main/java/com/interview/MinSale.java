package com.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ali on 12/25/2016.
 */
public class MinSale {

    public static void main(String args[] ) throws Exception {

        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int minStart=Integer.MAX_VALUE , maxFinish = Integer.MIN_VALUE;
        int[] start = new int[n];
        int[] finish = new int[n];
        int[] price = new int[n];
        int i=0;
        for(;i<n;i++){
            start[i] = sc.nextInt();
            finish[i] = sc.nextInt();
            price[i] = sc.nextInt();
            if(minStart > start[i]){
                minStart = start[i];
            }
            if(maxFinish < finish[i]){
                maxFinish = finish[i];
            }
        }

        sortByFinishTime(start,finish,price,n);
        i=minStart;
        int startTime=minStart;
        int minPrice = Integer.MAX_VALUE;
        List<Integer> news = new ArrayList<Integer>();
        List<Integer> newf = new ArrayList<Integer>();
        List<Integer> newp = new ArrayList<Integer>();
        int index = 0;
        while(i<=maxFinish){
            for(int j=0;j<n;j++){
                if(i > finish[j]){
                    continue;
                }else if(i >= start[j] && i <= finish[j]){
                    if(minPrice > price[j]){
                        minPrice = price[j];
                    }
                }else if(i < start[j]){
                    break;
                }
            }
            if(i == startTime){
                news.add(index, startTime);
                newf.add(index, i);
                newp.add(index, minPrice);
            }else if(minPrice == newp.get(index)){
                newf.add(index,i);
            }else{
                index++;
                news.add(index, newf.get(index-1)+1);
                newf.add(index, i);
                newp.add(index, minPrice);
            }
            i++;
        }
        for (int j = 0; j < news.size(); j++) {
            System.out.println(news.get(j)+" "+newf.get(j)+" "+newp.get(j));
        }
    }

    static void sortByFinishTime(int[] s, int[] f, int[] p, int n){

        for(int i=n/2-1;i>=0;i--){
            maxHeapify(s,f,p,i,n);
        }

    }

    private static void maxHeapify(int[] s, int[] f, int[] p, int i, int n) {
        int max = i;
        int L = (i<<1)+1;
        int R = L + 1;
        if(L<n && f[L] < f[max]) {
            max = L;
        }
        if(R<n && f[R] < f[max]) {
            max = R;
        }
        if(i != max){
            swap(s,f,p,i,max);
            maxHeapify(s,f,p,max,n);
        }
    }

    private static void swap(int[] s, int[] f, int[] p, int i, int max) {
        swap(s,i,max);
        swap(f,i,max);
        swap(p,i,max);
    }

    private static void swap(int[] a, int p, int q) {
        int temp = a[p];
        a[p] = a[q];
        a[q] = temp;
    }
}
