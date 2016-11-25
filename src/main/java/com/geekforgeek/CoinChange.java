package com.geekforgeek;

import java.util.Arrays;

/**
 * Created by Ali on 11/1/2016.
 */
public class CoinChange {

    public static void main(String args[]) {

        int[] coins = {1,2,3,5};
        int amount = 19;

        int noOfCoins = findTopDown(coins, amount);
        System.out.println(noOfCoins);

        noOfCoins = findBottomUp(coins, amount);
        System.out.println(noOfCoins);
    }

    private static int findBottomUp(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]])+1;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount] ;
    }

    private static int findTopDown(int[] coins, int amount) {
        if(amount < 0)return -1;
        return findTopDown(coins, amount, new int[amount]);
    }

    private static int findTopDown(int[] coins, int amount, int[] amounts) {

        if(amount < 0 )return -1;
        if(amount == 0) return 0;

        if(amounts[amount-1] != 0)return amounts[amount-1];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findTopDown(coins, amount - coins[i], amounts);

            if(res >= 0 && res < min){
                min = res + 1;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
