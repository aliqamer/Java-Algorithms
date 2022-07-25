package com.interview;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Zalando3 {

    public static void main(String[] args) {
//        String[] n = new String[] {"039", "4", "14", "32", "", "34", "7"};
        String[] n = new String[] {"801234567", "180234567", "0", "189234567", "891234567", "98", "9"};
        System.out.println(new Zalando3().solution(n));
    }

    public int solution(String[] E) {
        // write your code in Java SE 8
        TreeMap<Integer, Set> map = new TreeMap<>();

        // Set<Integer> s = new HashSet<>();

        for (int x = 0; x < E.length; x++) {
            String empDays = E[x];
                for(int k=0; k<empDays.length();k++){
//                s.add(Integer.parseInt(empDays.charAt(k)+""));
                    if(map.containsKey(Integer.parseInt(empDays.charAt(k)+""))) {
                        Set set = map.get(Integer.parseInt(empDays.charAt(k) + ""));
                        set.add(x);
                        map.put(Integer.parseInt(empDays.charAt(k)+""), set);
                    } else {
                        Set<Integer> s = new HashSet<>();
                        s.add(x);
                        map.put(Integer.parseInt(empDays.charAt(k)+""), s);
                    }
                }
        }

        for (int i = 0; i < 10; i++) {
            if(!map.containsKey(i)){
                map.put(i, new HashSet());
            }
        }

        int max = 0;
        for (int i = 0; i < 10; i++) {
            Set<Integer> set1 = map.get(i);
            if(set1.size() == 0){
                continue;
            }
            for (int j = i+1; j < 10; j++) {
                Set<Integer> set2 = new HashSet<>(map.get(j));
                if(set2.size() == 0){
                    continue;
                }
                set2.addAll(set1);
                if(max < set2.size()){
                    max = set2.size();
                }
                if(max == E.length) {
                    return max;
                }
            }
        }
        return max;
    }
}
/*
Example test:   ['039', '4', '14', '32', '', '34', '7']
WRONG ANSWER (got 6 expected 5)

Example test:   ['801234567', '180234567', '0', '189234567', '891234567', '98', '9']
OK

Example test:   ['5421', '245', '1452', '0345', '53', '354']
OK
 */