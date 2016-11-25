package com.geekforgeek;

import java.util.Scanner;

/**
 * Created by Ali on 10/31/2016.
 */
public class PatternSearching {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] res = new String[t];
        int i=0;
        sc.nextLine();
        while(t-->0){
            String input = sc.nextLine();
            String pattern = sc.nextLine();
            res [i++] = findPattern(input, pattern);
        }
        for (int j = 0; j < res.length; j++) {
            System.out.println(res[j]);
        }

    }

    private static String findPattern(String input, String pattern) {

        int index = 0;
        int temp = -1;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == pattern.charAt(index)){
                if(temp == -1)
                    temp = i;
               index++;
            }else{
                index = 0;
                if(temp != -1)
                    i = temp+1;
                temp = -1;
            }
            if(index == pattern.length()){
                return "found";
            }
        }
        return "not found";
    }

    private static void findPattern2(String input, String pattern) {

        int N = input.length();
        int M = pattern.length();
        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++)
        {
            int j;
        /* For current index i, check for pattern match */
            for (j = 0; j < M; j++)
                if (input.charAt(i+j) != pattern.charAt(j))
                    break;

            if (j == M)  // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
                System.out.println("Pattern found at index"+ i);
        }
    }
}
