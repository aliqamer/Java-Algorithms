package com.geekforgeek;

import java.util.Scanner;

/**
 * Created by Ali on 10/31/2016.
 *http://www.practice.geeksforgeeks.org/problem-page.php?pid=290
 *
 * Given a string ‘str’, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.  For example "abab" can be created by appending "ab" to "ab", but "abac" cannot be created by appending a substring to itself.

 Input:
 The first line contains T denoting the number of testcases. Then follows description of testcases. Each case contains a string.


 Output:
 For each test case, output "True" if it is possible and "False" if not.


 Constraints:
 1<=T<=50
 1<=Length of String<=1000


 Example:
 Input:
 1
 abcabcabc

 Output:
 True

 Explanation :
 The given string is 3 times repetition of "abc"
 */
public class SubStringFormation {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        boolean[] res = new boolean[t];
        int i=0;
        sc.nextLine();
        while(t-->0){
            String s = sc.nextLine();
            res[i++] = checkSubstring(s);
        }
        for (int j = 0; j < res.length; j++) {
            if(res[j]){
                System.out.println("True");
            }else{
                System.out.println("False");
            }
        }

    }

    private static boolean checkSubstring(String s) {

        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        int pointer1 = 0, pointer2=1;
        while(pointer2<chars.length && chars[pointer1] != chars[pointer2]){
            sb.append(chars[pointer2]);
            pointer2++;
        }
        if(sb.toString().equals(s)){
            return false;
        }
        while(pointer2 < chars.length){
            if(pointer2+sb.length() > chars.length || ! sb.toString().equals(s.substring(pointer2,pointer2+sb.length()))){
                return false;
            }pointer2 += sb.length();
        }
        return true;
    }
}
