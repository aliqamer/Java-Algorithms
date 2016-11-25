package com.home;

import java.util.Arrays;

/**
 * Created by Ali on 9/28/2016.
 * Q) Replace every element by its Immediate greater element


 */
public class AddOneInArray {
    public static void main(String args[]){
        AddOneInArray obj = new AddOneInArray();
        int[] a = new int[]{2,4,7,12,8,11,20};
        obj.addOne(a);
        Arrays.stream(a).forEach(System.out::println);
    }

    private void addOne(int[] a) {

        int size = a.length;
        for (int i = 0; i < size; i++) {
            a[i] = ++a[i];
        }
    }
}
