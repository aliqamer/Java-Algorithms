package com.geekforgeek;

import java.util.*;

/**
 * Created by Ali on 10/31/2016.
 */
public class SortingByFrequency {

    public static void main(String args[]) {

        SortingByFrequency object = new SortingByFrequency();

//        int[] a = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};
//        int[] a = {5,5,4,6,4,4,5};


        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<int[]> res = new ArrayList<>();
        int n;
        while(t-->0){
            n = sc.nextInt();
            int[] a = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            sortByFrequency(a);
            res.add(a);
        }

        for (int i = 0; i < res.size(); i++) {
            int[] a = res.get(i);
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[j]+" ");
            }
            System.out.println();
        }
    }

    private static void sortByFrequency(int[] a) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if(map.containsKey(a[i])){
                map.put(a[i],map.get(a[i])+1);
            }else{
                map.put(a[i], 1);
            }
        }

        Set<Integer> keys = map.keySet();

        int n = keys.size();
        int[] keysArr = new int[n];
        int[] values = new int[n];

        Iterator<Integer> iterator = keys.iterator();
        int i=0;
        while(iterator.hasNext()){
            keysArr[i] = iterator.next();
            values[i] = map.get(keysArr[i]);
            i++;
        }

        int j,k,m;
        for (i = 1; i < n ; i++) {

            k = values[i];
            m = keysArr[i];
            j = i-1;

            while(j >= 0 && k > values[j]){
                values[j+1] = values[j];
                keysArr[j+1] = keysArr[j];
                j--;
            }
            values[j+1] = k;
            keysArr[j+1] = m;
        }

        i = 0;
        for (int l = 0; l < a.length; ) {
            m = values[i];
            while(m-->0){
                a[l++] = keysArr[i];
            }
            i++;
        }


    }
}
