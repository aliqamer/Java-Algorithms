package com.interview;

/**
 * Created by Ali on 11/27/2016.
 */
public class HelicoptorLanding {

    public static void main(String args[]) {


        String[] s = {"x#o#o#o#x#o", "x#o#o#o#x#x", "x#o#o#o#x#x", "x#o#x#o#x#o", "x#o#x#o#x#o"};
        int r = landingPosition(new int[]{6,5}, s);
        System.out.println(r);
    }

    public static int landingPosition(int[] input1,String[] input2){

        int n = input1[0];
        int m = input1[1];
        char[][] input = new char[m][n];
        try{
            for(int i=0; i<m;i++){
                char[] row = input2[i].toCharArray();
                int x = 0;
                for(int j=0;j<n;j++){
                    input[i][j] = row[x];
                    x+=2;
                }
            }
        }catch(Exception e){
            return -1;
        }

        /*for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(input[i][j]+" ");
            }
            System.out.println();
        }*/

        int[][] dp = new int[m][n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            if(input[0][i] == 'x'){
                dp[0][i] = -1;
            }else{
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            if(input[i][0] == 'x'){
                dp[i][0] = -1;
            }else{
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(input[i][j] == 'x'){
                    dp[i][j] = -1;
                }else if(dp[i-1][j] != -1 && dp[i][j-1] != -1 && dp[i-1][j-1] != -1){
                    dp[i][j] = dp[i-1][j-1]+1;
                    if(max < dp[i][j]){
                        max = dp[i][j];
                    }
                }else{
                    dp[i][j] = 1;
                    if(max < 1){
                        max = 1;
                    }
                }
            }
        }
        return max;
    }

}
