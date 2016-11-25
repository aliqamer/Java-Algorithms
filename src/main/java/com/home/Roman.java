package com.home;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ali on 10/9/2016.
 */
public class Roman {

    private static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(1,"I");
        map.put(5,"V");
        map.put(9,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
    }

    public static void main(String args[]) {

        Roman object = new Roman();
        String res = object.covertToRoman(230);
        System.out.println(res);
    }

    private String covertToRoman(int n) {

        String res = "";
        for (int i = n; i>0; i--) {
            if(n <= 10){
                res += map.get(n);
                i = i - n;
            }

            else if(n>10 && n < 40){
                res += map.get(10);
                i = n - 10;
            }

            else if(n>=40 && n <= 50){
//                res += map
            }

        }


    return null;
    }
}
