package com.geekforgeek;

import java.util.*;

/**
 * Created by Ali on 10/30/2016.
 *
 * Given an array of integers A and a sum B, find all unique combinations in A where the sum is equal to B.

 ach number in A may only be used once in the combination.

 Note:
 All numbers will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The combinations themselves must be sorted in ascending order.
 If there is no combination possible the print "Empty" (without qoutes).
 Example,
 Given A = 10,1,2,7,6,1,5 and B(sum) 8,

 A solution set is:

 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6]
 *
 * input:
 2
 7
 10 1 2 7 6 1 5
 8
 5
 8 1 8 6 8
 12
 */
public class CombinationSum {

    static int[] b = {0,0,0,0,0,0,0,0,0,0,0,0};
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int sum;
        List<Set<String>> res = new ArrayList<>();
        int n;
        while(t-->0){
            n = sc.nextInt();
            int[] a = new int[n];
            b = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            sum = sc.nextInt();
            Set<String> ss = new HashSet<>();
            Set<String> set = findCombinationSum(a,0,n-1,sum,ss);
            res.add(set);
        }
        for (int j = 0; j < res.size(); j++) {
            Set<String> strings = res.get(j);

            if(strings.isEmpty()){
                System.out.println("Empty");
                continue;
            }
            List<String> l = new ArrayList<>(strings);
            Collections.sort(l);
            for (int k = 0; k < l.size(); k++) {
                String next = l.get(k);
                System.out.print("("+next.charAt(0));
                for (int x = 1; x < next.length(); x++) {
                    System.out.print(" "+next.charAt(x));
                }
                System.out.print(") ");
            }
            System.out.println();
        }

    }

    private static Set<String> findCombinationSum(int[] a, int k,int n,int sum, Set<String> l) {

        if(k == n){
            b[k] = 0;
            findSum(a,n,sum,l);
            b[k] = 1;
            findSum(a,n,sum,l);
            return l;
        }
        b[k] = 0;
        findCombinationSum(a,k+1,n,sum,l);
        b[k] = 1;
        findCombinationSum(a,k+1,n,sum,l);
        return l;
    }

    private static void findSum(int[] a, int n, int sum, Set<String> l) {

        int s = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if(b[i] == 1){
                s = s + a[i];
                list.add(a[i]);
            }
        }
        if(s == sum){
            Collections.sort(list);
            String result = "";
            for (int i = 0; i < list.size(); i++) {
                result += list.get(i);
            }
            l.add(result);
        }
    }
}
