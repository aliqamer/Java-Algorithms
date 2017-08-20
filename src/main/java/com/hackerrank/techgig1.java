package com.hackerrank;

/**
 * Created by Ali on 1/7/2017.
 */
public class techgig1 {

    public static void main(String args[]) {

        String[] s1 = {"2#3","2#4"};
        String[] s2 = {"2#2","3#4"};
        Mathematician(2,s1,s2);

    }

    public static String Mathematician(int input1,String[] input2,String[] input3)
    {
        //Write code here
        if(input2.length != input3.length){
            return "invalid";
        }else{

            int[][] m1 = getMatrix(input1, input2);
            int[][] m2 = getMatrix(input1, input3);



            for(int i=0;i<input1;i++){
                for(int j=0;j<input1;j++){
                    System.out.print(m1[i][j]+" ");
                }
                System.out.println();
            }

            for(int i=0;i<input1;i++){
                for(int j=0;j<input1;j++){
                    System.out.print(m2[i][j]+" ");
                }
                System.out.println();
            }

        }
        return "no";
    }

    private static int[][] getMatrix(int input1, String[] input2) {
        int[][] m1 = new int[input1][input1];
        for(int i=0;i<input1;i++){
            String row = input2[i];
            String[] r = row.split("#");
            for(int j=0;j<input1;j++){
                m1[i][j] = Integer.parseInt(r[j]);
            }
        }
        return m1;
    }
}
