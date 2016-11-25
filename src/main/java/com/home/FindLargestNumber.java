package com.home;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ali on 9/8/2016.
 */

public class FindLargestNumber {
    public static void main(String str[]) {

        FindLargestNumber obj = new FindLargestNumber();
        List<Integer> list = new ArrayList<>();
        /*list.add(92);
        list.add(30);
        list.add(34);
        list.add(5);
        list.add(9);
        list.add(11);//9925343011*/
        list.add(89);
        list.add(8);
        String result = obj.findGreatest(list);
        System.out.println(result);

//        int[] a = new int[]{3, 30, 34, 5, 9};
        Integer[] a = new Integer[]{250, 74, 659, 931, 273, 545, 879, 924};
        System.out.println(findLargest(a));
    }

    private static String findLargest(Integer[] a){
        String[] arr = new String[a.length];
        for(int i=0; i<a.length; i++){
            arr[i]=String.valueOf(a[i]);
        }

        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        while(sb.charAt(0)=='0' && sb.length()>1){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    private static String mergeTwo(String res, String curr) {

        String n1 = res+curr;
        String n2 = curr+res;

        BigInteger bn1 = new BigInteger(n1);
        BigInteger bn2 = new BigInteger(n2);
        if(bn1.compareTo(bn2) > 0){
            return n1;
        }else{
            return n2;
        }
    }

    private String findGreatest(List<Integer> a) {

        String result = "";
        int max, temp, digits, index,i=0;
        while(a.size()>0){
            max = a.get(0);
            digits = getDigits(max);
            index = 0;

            for(int j = 1;j<a.size();j++) {
                temp = a.get(j);
                int currDigits = getDigits(temp);
                if(digits == currDigits){
                    if(temp > max){
                        max = temp;
                        index = j;
                        digits = getDigits(max);
                    }
                }else if(currDigits < digits){
                    int prevMax = getNumberWithDigits(max, currDigits);
                    if(temp >= prevMax && currDigits==1){
                        index = j;
                        max = temp;
                        digits = getDigits(max);
                    }
                }else if(currDigits > digits){
                    int currNumber = getNumberWithDigits(temp, digits);
                    if(currNumber > max){
                        index = j;
                        max = temp;
                        digits = getDigits(max);
                    }
                }
            }
            result = result + a.remove(index);
        }

        return result;
    }

    //10020,2
    private int getNumberWithDigits(int temp, int digitCount) {
        int digits=0;
        while(temp>0){
            digits++;
            temp = temp/10;
            if(digitCount==getDigits(temp)){
                break;
            }
        }
        return temp;

    }

    private int getDigits(int temp) {
        int digits=0;
        while(temp>0){
            digits++;
            temp = temp/10;
        }
        return digits;
    }
}
