package com.home;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 10/8/2016.
 */
public class UniqueCharInString {
    public static void main(String args[]){

        String s1 = "qameralil";
        String s2 = "aliqameri";

        UniqueCharInString obj = new UniqueCharInString();
        boolean flag = obj.checkUnique(s1,s2);
        System.out.println(flag);
    }

    public boolean checkUnique(String s1, String s2) {

        if(s1.length() != s2.length()){
            return false;
        }
        List<String> list = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            list.add(s1.charAt(i)+"");
        }
        try{
            for (int i = 0; i < s1.length(); i++) {
                list.remove(s2.charAt(i)+"");
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
