package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ArraySubsets {
    public static void main(String[] args) {
        int[] input = {1,2,3};
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0, input, new ArrayList<Integer>(), subsets);
        for (int i = 0; i < subsets.size(); i++) {
            System.out.println(subsets.get(i));
        }
    }

    private static void generateSubsets(int index, int[] input, ArrayList<Integer> current, List<List<Integer>> subsets) {

        subsets.add(new ArrayList<>(current));
        for (int i = index; i < input.length; i++) {
            current.add(input[i]);
            generateSubsets(i+1, input, current, subsets);
            current.remove(current.size()-1);
        }
    }
}
