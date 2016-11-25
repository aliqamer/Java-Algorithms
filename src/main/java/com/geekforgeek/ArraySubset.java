package com.geekforgeek;

import java.util.*;

/**
 * Created by Ali on 10/30/2016.
 */
public class ArraySubset {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Set<String>> res = new ArrayList<>();
        int n;
        while(t-->0){
            n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
                b[j] = 0;
            }
            Set<String> ss = new HashSet<>();
            Set<String> set = findCombinationSubSet(a,0,n-1,b,ss);
            res.add(set);
        }

        for (int j = 0; j < res.size(); j++) {
            Set<String> strings = res.get(j);
            List<String> l = new ArrayList<>(strings);
            Collections.sort(l);
            for (int k = 0; k < l.size(); k++) {
                String next = l.get(k);
                if(next.isEmpty()){
                    System.out.print("()");
                    continue;
                }
                System.out.print("("+next.charAt(0));
                for (int x = 1; x < next.length(); x++) {
                    System.out.print(" "+next.charAt(x));
                }
                System.out.print(")");
            }
            System.out.println();
        }

    }

    private static Set<String> findCombinationSubSet(int[] a, int k, int n, int[] b, Set<String> ss) {

        if(k == n){
            b[k]=0;
            findSubSet(a,b,n,ss);
            b[k]=1;
            findSubSet(a,b,n,ss);
            return ss;
        }
        b[k] = 0;
        findCombinationSubSet(a,k+1,n,b,ss);
        b[k] = 1;
        findCombinationSubSet(a,k+1,n,b,ss);
        return ss;
    }

    private static void findSubSet(int[] a, int[] b, int n, Set<String> ss) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if(b[i] == 1){
                sum++;
                list.add(a[i]);
            }
        }
        if(sum == 0){
            ss.add("");
        }else{
            Collections.sort(list);
            String result = "";
            for (int i = 0; i < list.size(); i++) {
                result += list.get(i);
            }
            ss.add(result);
        }
    }
}
