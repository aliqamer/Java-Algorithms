package com.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ali on 10/22/2016.
 */
public class StringPrice {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] res = new int[t];
        int i=0;
        int n;
        sc.nextLine();
        while(t-->0){
            String s = sc.nextLine();
            res[i++] = getPrice(s);
        }
        for(int k=0; k<res.length;k++){
            System.out.println(res[k]);
        }
    }

    private static int getPrice(String s) {
        int size = s.length();
        int count = 0;
        List<String> list = new ArrayList<String>();
        String tempStr;
        String newS = s+s;
        int half = size/2;
        for (int i = 0; i < size; i++) {
            tempStr = newS.substring(i , size+i);
            if(list.contains(tempStr)){
                break;
            }else if(i > half) {
                count = size;
                break;
            }
            count++;
            list.add(tempStr);
        }
        return count;
    }
}
