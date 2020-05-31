package com.geekforgeek;

/*
find closest delivery locations
starts from 0,0
input is
total number of locations int
list of locations coordinates (List<List<Integer>>)
number of deliverables to be made int

find sqrt of (sum of sq of x y coordinates)
 */

import java.util.*;

public class Amazon1 {

    public static void main(String args[]) {

        Amazon1 object = new Amazon1();
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> xy = new ArrayList<>();
        xy.add(1);
        xy.add(2);
        input.add(xy);
        xy = new ArrayList<>();
        xy.add(1);
        xy.add(-1);
        input.add(xy);
        xy = new ArrayList<>();
        xy.add(3);
        xy.add(4);
        input.add(xy);
        final List<List<Integer>> closestLocations = object.findClosestLocations(3, input, 2);

        for (int i = 0; i < closestLocations.size(); i++) {
            System.out.println("["+closestLocations.get(i).get(0) + "," + closestLocations.get(i).get(1)+"]");
        }

    }

    private List<List<Integer>> findClosestLocations(int n, List<List<Integer>> input, int d) {

        Map<Double, Integer> map = new HashMap<>();
        List<Double> sqrt = new ArrayList<>();

        for(int i=0; i<n; i++){
            final double sqrt1 = Math.sqrt(Math.pow(input.get(i).get(0), 2) + Math.pow(input.get(i).get(1), 2));
            map.put(sqrt1, i);
            sqrt.add(sqrt1);
        }
        Collections.sort(sqrt);

        int deleted = 0;
        for (int i = d; i < n; i++ ) {
            input.remove((int)(map.get(sqrt.get(i))-deleted++));
        }
        return input;
    }
}
