package com.interview;

public class Zolando1 {
    public static void main(String[] args) {

        int [] a = new int[] {1,2,5,8,9,9,12,16,24,29,30,39};
        int r = solution(a,39);

    }

    public static int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            int k = A[m];
            if(A[m] == X) {
                return m;
            }
            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m+1;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
}
