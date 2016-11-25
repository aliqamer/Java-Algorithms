package com.home;

import java.util.Stack;

/**
 * Created by Ali on 10/16/2016.
 */
public class LonestParanthesis {
     /*for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("(")){
                stack.push(i);
            }else{
                stack.pop();
                if(!stack.isEmpty()){
                    result = Math.max(result, i - stack.pop());
                }else {
                    stack.push(i);
                }
            }
        }*/


    /*private int findLength(String s){
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int result = 0;
        char ch;
        for(int i=0;i<s.length();i++){
            ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }else{
                st.pop();

                if(!st.empty()){
                    result = Math.max(result, i - st.peek());
                }else{
                    st.push(i);
                }
            }
        }
        return result;
    }*/

    public static void main(String args[]) {

        LonestParanthesis object = new LonestParanthesis();

//        String s = "(()(()";
//        String s = "(()()()()(()))";
        String s = "(())(((())";
       // object.findLength(s);

        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int result=0;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);

            if(ch == '('){
                st.push(i);
            }else {

                st.pop();
                if(!st.empty()){

                    result = Math.max(result, i - st.peek());
                }else{
                    st.push(i);
                }
            }
        }
        System.out.println(result);

        /*Stack<String> stack = new Stack<>();
        String[] arr = s.split("");

        int count = 0, max = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("(")) {
                stack.push(arr[i]);
//                count++;
            }else if(arr[i].equals(")")){
                if(!stack.isEmpty()){
                    stack.pop();
                    count = count+2;
                }else{
                    if(max < count){
                        max = count;
                    }
                    count = 0;
                }
            }
        }
        if(stack.isEmpty() && max < count){
            max = count;
        }else if(!stack.isEmpty()){
            count = count - stack.size();
            if(max < count){
                max = count;
            }
        }*/

        /*String[] arr = s.split("");

        Stack<int[]> stack = new Stack<int[]>();
        int max = 0;

        s = "(()(()))";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                int[] a = {i,0};
                stack.push(a);
            }else{
                if(stack.empty()||stack.peek()[1]==1){
                    int[] a = {i,1};
                    stack.push(a);
                }else{
                    stack.pop();
                    int currentLen=0;
                    if(stack.empty()){
                        currentLen = i+1;
                    }else{
                        currentLen = i-stack.peek()[0];
                    }
                    max = Math.max(max, currentLen);
                }
            }
        }*/

//        return max;
//        System.out.print(max);

    }
}
