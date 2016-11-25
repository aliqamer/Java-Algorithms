package com.home;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ali on 9/15/2016.
 *
 A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends
 in the binary representation of N.
 For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
 The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
 The number 20 has binary representation 10100 and contains one binary gap of length 1.
 The number 15 has binary representation 1111 and has no binary gaps.
 Write a function:
 class Solution { public int solution(int N); }
 that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
 For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and
 so its longest binary gap is of length 5.
 Assume that:
 N is an integer within the range [1..2,147,483,647].
 Complexity:
 expected worst-case time complexity is O(log(N));
 expected worst-case space complexity is O(1). *
 */
public class BinaryGap {

    public static void main(String str[]){

        String line = "1,2,3,4,5,6,10,8";
        String[] arr = line.split(",");

        List<Integer> list = new LinkedList<>();

        int retain = 1, delete=2;
        int r = 0, d = 0;
        for(int i=0;i<arr.length;i++){
            if(r < retain){
                list.add(Integer.parseInt(arr[i]));
                r++;
            }else if(d < delete) {
                //skip
                d++;
            }else {
                list.add(Integer.parseInt(arr[i]));
                r = 1;
                d = 0;
            }
        }

        int i = 0;
        for(;i<list.size()-1;i++){
            System.out.print(list.get(i)+",");
        }
        System.out.print(list.get(i));


//        BinaryGap obj = new BinaryGap();
//        int n = obj.binaryGap(1041);
//        System.out.println(n);
//        System.out.println(Integer.MAX_VALUE);
    }

    private int binaryGap(int N) {

        char[] arr = Integer.toBinaryString(N).toCharArray();
        int count = 0, maxCount = 0;
        boolean on = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '1'){
                if(count > maxCount)
                    maxCount = count;
                on = true;
                count = 0;
            }else if(arr[i] == '0'){
                if(on)
                    count++;
            }
        }
        return maxCount;
    }

}
