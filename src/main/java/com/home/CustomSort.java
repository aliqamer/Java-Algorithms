package com.home;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Ali on 10/8/2016.
 */

class myComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer x, Integer y) {

        String xy = x+""+y;
        String yx = y+""+x;
        return xy.compareTo(yx) > 0 ? 1 : 0;
    }
}

public class CustomSort {
    public static void main(String args[]){
        String[] arr = new String[]{"250", "74", "659", "931", "273", "545", "879", "924"};
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });

//        sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
