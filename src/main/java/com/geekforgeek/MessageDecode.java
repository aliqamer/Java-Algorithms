package com.geekforgeek;

import java.util.Scanner;

/**
 * Created by Ali on 10/23/2016.
 */
public class MessageDecode {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] res = new int[t];
        int i=0;
        int n;
        while(t-->0){
            n = sc.nextInt();sc.nextLine();
            String s = sc.nextLine();
            res[i++] = find(s);
        }
        for(int k=0; k<res.length;k++){
            System.out.println(res[k]);
        }
    }

    static int find(String s){

        if(s.isEmpty()){
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 0;

        for (int i = 1; i < s.length(); i++) {

            int prev = Integer.parseInt(s.charAt(i - 1) + "");
            int curr = Integer.parseInt(s.charAt(i) + "");
            if(curr == 0 && (prev > 2 || prev == 0)){
                return 0;
            }

            if(prev == 1 || (curr < 7 && prev == 2)){
                if(i > 1){
                    dp[i] = dp[i-2]+2;
                }else{
                    dp[i] = 2;
                }
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
    }

    static int find2(String s){
        int count = 1, k;
        if(s.charAt(0) == '0'){
            return 0;
        }
        for(int i=0;i<s.length();i++){
            k = i;
            if(s.charAt(k) == '0'){
                if(s.charAt(i-1) != '1' || s.charAt(i-1) != '2'){
                    return 0;
                }
            }
            for(int j=k+2;j<=s.length();j++,k++){
                if(Integer.parseInt(s.substring(k,j)) < 27){
                    count++;
                    k++;
                    j++;
                }
            }
        }
        return count;
    }
}
