package com.home;

/**
 * Created by Ali on 9/15/2016.
 */
public class Rakuten {

    public static void main(String args[]) {
        Rakuten obj = new Rakuten();
//        int index = obj.solution(5,9);
        int index = obj.solution(2,20);
//        int index = obj.solution(1,1);
        System.out.println(index);
    }

    public int solution(int M, int N) {

        if(M == N){
            return getDecimalValue(bitXor(getBinaryFormat(M), getBinaryFormat(N)));
        }
        String currentNumber = getBinaryFormat(M);
        String nextNumber;
        for (int i = M+1; i <= N; i++) {
            nextNumber = getBinaryFormat(i);
            currentNumber = matchLength(currentNumber, nextNumber);
            currentNumber = bitXor(currentNumber, nextNumber);
        }
        return getDecimalValue(currentNumber);
    }

    private int getDecimalValue(String current) {
        return Integer.parseInt(current, 2);
    }

    private String bitXor(String current, String next) {
        char[] currentCharacterArray = current.toCharArray();
        char[] nextCharacterArray = next.toCharArray();
        String xor = "";
        for (int i = 0; i < currentCharacterArray.length; i++) {
            if(currentCharacterArray[i] == nextCharacterArray[i]){
                xor = xor + "0";
            }else {
                xor = xor + "1";
            }
        }
        return xor;
    }

    private String matchLength(String current, String next) {
        if(current.length() < next.length()){
            while(current.length() != next.length()){
                current = "0" + current;
            }
        }
        return current;
    }

    private String getBinaryFormat(int m) {
        return Integer.toBinaryString(m);
    }
}
