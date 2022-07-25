package com.leetcode;

import java.util.Locale;

public class palindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
//        String s = " a0Pa";
//        s = " ";
//        s.isEmpty()
        s = s.toLowerCase(Locale.ROOT);
        boolean flag = false;
        for(int i=0, j=s.length()-1; i<j;) {

            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if(s.charAt(i++) != s.charAt(j--)) {
                System.out.println("not palindrom");
            }
        }
        System.out.println("palindrome");
    }
}
