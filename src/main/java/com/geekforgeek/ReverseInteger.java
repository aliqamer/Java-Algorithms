package com.geekforgeek;

/**
 * Created by Ali on 8/20/2017.
 */
public class ReverseInteger {

    public static void main(String args[]) {

        ReverseInteger object = new ReverseInteger();
        System.out.println(object.reverse(1234));
        System.out.println(object.reverse(1));
    }

    private int reverse(int x) {

        int newx = x;
        int res = 0;
        int prev_res = 0;
        if (x < Integer.MAX_VALUE && x > Integer.MIN_VALUE) {

            while (newx != 0) {

                int digit = newx % 10;
                res = res * 10 + digit;

                if ((res - digit) / 10 != prev_res) {
                    res = 0;
                    newx = 0;
                }

                prev_res = res;
                newx = newx / 10;

            }
        }
        return res;
    }

    /* Iterative function to reverse digits of num*/
    private int reversDigits(int num)
    {
        // Handling negative numbers
        boolean negativeFlag = false;
        if (num < 0)
        {
            negativeFlag = true;
            num = -num ;
        }

        int prev_rev_num = 0, rev_num = 0;
        while (num != 0)
        {
            int curr_digit = num%10;

            rev_num = (rev_num*10) + curr_digit;

            // checking if the reverse overflowed or not.
            // The values of (rev_num - curr_digit)/10 and
            // prev_rev_num must be same if there was no
            // problem.
            if ((rev_num - curr_digit)/10 != prev_rev_num)
            {
                System.out.println("WARNING OVERFLOWED!!!");
                return 0;
            }

            prev_rev_num = rev_num;
            num = num/10;
        }

        return (negativeFlag == true)? -rev_num : rev_num;
    }
}
