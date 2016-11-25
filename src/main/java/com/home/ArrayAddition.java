package com.home;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ali on 10/24/2016.
 */
public class ArrayAddition {

    public static void main(String args[]) {

        ArrayAddition object = new ArrayAddition();

        //addArray();

        //palindrome("abba");

//        rotateArry();

        logestVowel();


    }

    private static void logestVowel() {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int count = 0, max = 0;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u'){
                count++;
            }else{
                if(max<count){
                    max = count;
                }
                count = 0;
            }
        }
        if(max<count){
            max = count;
        }
        System.out.println(max);
    }

    private static void rotateArry() {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, k=t;
        List<int[]> result = new ArrayList<int[]>();
        while(t-->0){
            n = sc.nextInt();
            k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            result.add(rotateArray(a,k));
        }
        for (int i = 0; i < result.size(); i++) {
            //System.out.println(result.get(i));
            int[] arr = result.get(i);
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]+" ");
            }
        }

    }

    private static int[] rotateArray(int[] nums, int k) {

            if(k > nums.length){
                k=k%nums.length;
            }

            int[] result = new int[nums.length];

            for(int i=0; i < k; i++){
                result[i] = nums[nums.length-k+i];
            }

            int j=0;
            for(int i=k; i<nums.length; i++){
                result[i] = nums[j];
                j++;
            }

            System.arraycopy( result, 0, nums, 0, nums.length );

        /*int n = a.length;
        int[] tempArr = new int[n];
        int j=0;
        k=k%n;
        for (int i = n-k; i < n; i++) {
            tempArr[j++] = a[i];
        }
        j=n-k-1;
        for (int i = n-1; i >= k; i--) {
            a[i] = a[j--];
        }
        j=0;
        for (int i = 0; i < k; i++) {
          a[j++] = tempArr[i];
        }
        return a;*/
        return nums;
    }

    private static void palindrome(String abba) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        sc.nextLine();
        String[] res = new String[t];
        int i=0;
        while(t-->0){
            res[i++] = checkPalindrom(sc.nextLine());
        }
        for (int j = 0; j < res.length; j++) {
            System.out.println(res[j]);
        }

    }

    private static String checkPalindrom(String s) {

        int n  = s.length();
        int i = 0 , j = n-1;
        boolean flg = true;
        while(i<j){
            if(s.charAt(i++) != s.charAt(j--)){
                flg = false;
                break;
            }
        }
        if(flg){
            if(n%2==0){
                return "YES EVEN";
            }else{
                return "YES ODD";
            }
        }else{
            return "NO";
        }
    }

    private static void addArray() {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for(int j=0;j<n;j++){
            a[j] = sc.nextInt();
        }
        for(int j=0;j<n;j++){
            b[j] = sc.nextInt();
        }
        for(int k=0; k<n;k++){
            System.out.print(a[k]+b[k]+" ");
        }
    }
}
