package com.geekforgeek;

import java.util.Scanner;

/**
 * Created by Ali on 11/12/2016.
 */
public class MaxSubSequenceInString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] res = new int[t];
        int i = 0;
        int n1, n2;
        while (t-- > 0) {
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            sc.nextLine();
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            res[i++] = getMaxSub(s1, s2);
        }
        for (int k = 0; k < res.length; k++) {
            System.out.println(res[k]);
        }
    }

    static int getMaxSub(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}