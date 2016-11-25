package com.geekforgeek;

/**
 * Created by Ali on 10/30/2016.
 */

import java.util.Scanner;

class WordBreak {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        boolean[] res = new boolean[t];
        int i=0;
        while(t-->0) {

            int size = sc.nextInt();sc.nextLine();
            String dictionary = sc.nextLine();
            String word = sc.nextLine();
            res[i++] = findWord(dictionary, word, size);
        }
        for (int j = 0; j < res.length; j++) {
            System.out.println(res[j]?1:0);
        }

//        printPermutation("abcd");
    }

    static boolean dictionaryContains(String s, String[] words){
        for (int i = 0; i < words.length; i++) {
            if(s.compareTo(words[i]) == 0 ){
                return true;
            }
        }
        return false;
    }

    private static boolean findWord(String dictionary, String word, int size) {
        String[] words = dictionary.split(" ");

        if(word.isEmpty()){
            return true;
        }
        for (int i = 1; i <= word.length(); i++) {
            if(dictionaryContains(word.substring(0,i), words) && findWord(dictionary,word.substring(i, word.length()),size) ){
                return true;
            }
        }
        return false;
    }


    /*private static void printPermutation(String word){
        if(word.isEmpty()){
            return;
        }

        for (int i = 0; i < word.length(); i++) {
            System.out.println(word);
            printPermutation(word.substring(i, word.length()));
        }
    }*/
}