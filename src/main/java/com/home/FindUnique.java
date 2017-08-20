package com.home;

import java.util.*;

/**
 * Created by Ali on 12/13/2016.
 */
public class FindUnique {

    private static int lonelyInteger(int[] a) {
        Map<Integer,Integer> map = new HashMap<>();

        //map.put(a[0],1);
        for(int i=0;i<a.length;i++){
            if(map.containsKey(a[i])){
                map.remove(a[0]);
            }else{
                map.put(a[i],1);
            }
        }
        Set s = map.keySet();
        Iterator it = s.iterator();
        return (int) it.next();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
    }
}
