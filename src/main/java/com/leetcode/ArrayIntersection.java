package com.leetcode;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayIntersection {

    public static void main(String[] args) {

    }

    public static int[] intersect(int[] num1, int[] num2) {

        if(num1.length > num2.length) {
            return intersect(num2, num1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : num1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int n: num2) {
            int count = map.getOrDefault(n, 0);
            if(count > 0) {
                res.add(n);
                map.put(n, count -1);
            }
        }

        int[] output = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            output[i] = res.get(i);
        }
        return output;

    }
}
