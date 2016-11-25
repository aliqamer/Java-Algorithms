package com.interview;

import java.util.Scanner;

/**
 * Created by Ali on 10/22/2016.
 */
public class TownFoodSleepType {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();sc.nextLine();
        int i=0;
        String food = sc.nextLine();
        String sleep = sc.nextLine();
        int q = sc.nextInt();
        int[] res = new int[q];

        while(q-- > 0){
            int l = sc.nextInt();
            int r = sc.nextInt();

            res[i++] = getCount(food, sleep,l , r);
        }
        for(int k=0; k<res.length;k++){
            System.out.println(res[k]);
        }

    }

    private static int getCount(String food, String sleep, int l, int r) {

        char f , s;
        int count = 0;
        for (int i = l-1; i < r; i++) {
            f = food.charAt(i);
            s = sleep.charAt(i);
            for (int j = i+1; j < r; j++) {
                if(f == food.charAt(j) || s == sleep.charAt(j)){
                    count++;
                }
            }
        }
        return count;
    }
}
