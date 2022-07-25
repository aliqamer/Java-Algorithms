package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FruitInBasket {

    public static void main(String[] args) {

        int[] a = {1,1,2,1,3,3,2,2,2};
        System.out.println(totalFruit(a));
    }

    private static int totalFruit(int[] tree) {

        if(tree == null || tree.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(tree[0], 0);
        int i=0,j=1;
        int max = 1;
        while(j<tree.length) {
            if(map.size() == 1 || map.containsKey(tree[j])) {
                map.put(tree[j], j++);
                max = Math.max(max, j-i);

            } else {
                int prev = tree[j-1];
                max = Math.max(max, j-i);

                for(Integer key : map.keySet()) {
                    if(prev != key) {
                        i = map.get(key)+1;
                        map.remove(key);
                        break;
                    }
                }
                map.put(tree[j], j++);
            }
        }
        return max;
    }

    /*private static int totalFruit(int[] tree) {

        if(tree == null || tree.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        int i = 0, j=0;

        while (j< tree.length) {
            if(map.size() <= 2) {
                map.put(tree[j], j++);
            }

            if(map.size() > 2) {
                int min = tree.length - 1;
                for (int value : map.values()) {
                    min = Math.min(min, value);
                }
                i = min + 1;
                map.remove(tree[min]);
            }
            max = Math.max(max, j-i);
        }
        return max;
    }*/
}
