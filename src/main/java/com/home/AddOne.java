package com.home;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Ali on 9/12/2016.
 */
public class AddOne {

    public static void main(String str[]){

        AddOne obj = new AddOne();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1); a.add(1); a.add(1);
        a.add(3); a.add(2); a.add(1);
        a.add(1); a.add(2); a.add(5);
        a.add(9); a.add(6); a.add(5);
        ArrayList<Integer> res = obj.plusOne(a);
        for(Integer i : res){
            System.out.println(i);
        }
    }

        public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
            String str="";
            for (int i = 0; i <a.size() ; i++) {
                str = str + a.get(i);
            }
            BigInteger sum = new BigInteger(str);
            BigInteger one = new BigInteger("1");
            sum = sum.add(one);
            str = sum.toString();
            char[] chars = str.toCharArray();

            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                result.add(Integer.parseInt(chars[i]+""));
            }
            return result;
        }

    public ArrayList<Integer> plusOne1(ArrayList<Integer> a) {



        return null;
    }
}
