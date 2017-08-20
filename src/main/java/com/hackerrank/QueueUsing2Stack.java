package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Ali on 12/9/2016.
 * https://www.hackerrank.com/challenges/queue-using-two-stacks
 * Sample Input
 * 10
 * 1 42
 * 2
 * 1 14
 * 3
 * 1 28
 * 3
 * 1 60
 * 1 78
 * 2
 * 2
 * Sample Output
 * 14
 * 14
 */
public class QueueUsing2Stack {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int input, x;
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        List<Integer> result = new ArrayList<>();
        boolean isPushed = false, isPoped = false;
        while (t-- > 0) {
            input = sc.nextInt();
            switch (input) {
                case 1:

                    x = sc.nextInt();
                    if (isPushed) {
                        if (!st1.isEmpty() || (st1.isEmpty() && st2.isEmpty())) {
                            st1.push(x);
                        } else if (!st2.isEmpty()) {
                            st2.push(x);
                        }
                    }else{
                        if (st1.isEmpty()) {
                            while (!st2.isEmpty()) {
                                st1.push(st2.pop());
                            }
                            st1.push(x);
                        } else {
                            while (!st1.isEmpty()) {
                                st2.push(st1.pop());
                            }
                            st2.push(x);
                        }
                    }
                    isPushed = true;
                    isPoped = false;
                    break;
                case 2:
                    if(isPoped){
                        if(!st1.isEmpty()){
                            st1.pop();
                        }else if(!st2.isEmpty()){
                            st2.pop();
                        }
                    }else{
                        if (st1.isEmpty()) {
                            while (!st2.isEmpty()) {
                                st1.push(st2.pop());
                            }
                            st1.pop();
                        } else {
                            while (!st1.isEmpty()) {
                                st2.push(st1.pop());
                            }
                            st2.pop();
                        }
                    }
                    isPushed = false;
                    isPoped = true;

                    break;
                case 3:
                    if(isPoped){
                        if(!st1.isEmpty()){
                            result.add(st1.peek());
                        }else if(!st2.isEmpty()){
                            result.add(st2.peek());
                        }
                    }else if (st1.size() == 1) {
                        result.add(st1.peek());
                    } else if (st2.size() == 1) {
                        result.add(st2.peek());
                    } else if (st1.isEmpty()) {
                        while (!st2.isEmpty()) {
                            st1.push(st2.pop());
                        }
                        result.add(st1.peek());
                        isPushed = false;
                        isPoped = false;
                    } else {
                        while (!st1.isEmpty()) {
                            st2.push(st1.pop());
                        }
                        result.add(st2.peek());
                        isPushed = false;
                        isPoped = false;
                    }
            }
        }
        for (int n : result) {
            System.out.println(n);
        }
    }
}
