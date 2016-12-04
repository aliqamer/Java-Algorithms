package com.geekforgeek;

/**
 * Created by Ali on 12/4/2016.
 * Given two numbers as stings s1 and s2 your task is to multiply them. You are required to complete the function multiplyStrings which takes two strings s1 and s2 as its only argument and returns their product as strings.

 Input:
 The first line of input contains an integer T denoting the no of test cases. Then T test cases follow . Each test case contains two strings s1 and s2 .

 Output:
 For each test case in a new line the output will be a string denoting the product of the two strings s1 and s2.

 Constraints:
 1<=T<=100
 1<=length of s1 and s2 <=100

 Example(To be used only for expected output) :
 Input:
 2
 33 2
 11 23
 Output:
 66
 253
 *
 */
public class MutiplyString {

    public static void main(String args[]) {

        System.out.println(multiply("33", "2"));
    }

    public static String multiply(String num1, String num2) {
        String res = "";
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        int nm2 = Integer.parseInt(num2);
        int rem = 0;
        for (int i = n1.length-1; i >= 0; i--) {
            int t = nm2 * (n1[i]-48);
            res = (t+rem)%10+res;
            rem = (t+rem)/10;

            if(i == 0){
                res = rem + res;
            }
        }

        while(res.charAt(0) == '0')
            res = res.substring(1,res.length());
        return res;
    }
}
