package com.home;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Ali on 9/21/2016.
 */
public class UniqueString {
    public static void main(String s[]){
        UniqueString obj = new UniqueString();
        List<String> list = new ArrayList<>();
        list.add("ali3");
        list.add("ali1");
        list.add("ali");
        list.add("ali");
        list.add("ali2");
        List<String> str = obj.findUnique(list);
        str.stream().forEach(System.out::println);
    }

    private List<String> findUnique(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0;i<list.size();i++) {
            if(map.containsKey(list.get(i))){
                list.remove(i);
            }
        }
        return list;
    }

    private List<String> findDuplicate(List<String> list) {

        Set<String> set = new HashSet<>();

        return list.stream().filter(s -> set.add(s) == false).collect(Collectors.toList());

        //it also give duplicate
//        return list.stream().distinct().collect(Collectors.toList());
    }

}
