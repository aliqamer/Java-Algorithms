package com.geekforgeek;

import java.util.Scanner;

/**
 * Created by Ali on 10/31/2016.
 */
public class LongestPrefixSuffix {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] res = new int[t];
        int i=0;
        sc.nextLine();
        while(t-->0){
            String s = sc.nextLine();
            res[i++] = findPrefixSuffix(s);
        }
        for(int k=0; k<res.length;k++){
            System.out.println(res[k]);
        }
    }

    private static int findPrefixSuffix(String s) {

        int[] p = new int[s.length()];
        int i = 1;
        int len = 0;
        while(i < s.length()){

            if(s.charAt(i) == s.charAt(len)){
                len++;
                p[i] = len;
                i++;
            }else{

                if(len != 0){
                    len = p[len-1];
                }else{
                    p[i] = len;
                    i++;
                }
            }
        }
        return p[p.length-1];
    }
}
