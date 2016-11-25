package com.home;

/**
 * Created by Ali on 10/15/2016.
 */
public class MaxSumPath {

    public static void main(String args[]) {

        MaxSumPath object = new MaxSumPath();
//        int[] a = {2, 3, 7, 10, 12};
//        int[] b = {1, 5, 7, 8};
//        int[] a = {1, 2, 4};
//        int[] b = {1, 2, 7};
        int[] a = {12, 23, 28, 43, 44, 59, 60, 68, 70, 85, 88, 92, 124, 125, 136, 168, 171, 173,
                179, 199, 212, 230, 277, 282, 306, 314, 316, 325, 328, 336, 337, 363, 365, 368,
                369, 371, 374, 387, 394, 414, 422, 422, 427, 430, 435, 457 ,493, 506, 527, 531,
                538, 541, 546, 568, 583, 585, 650, 691, 730, 737, 751, 764, 778, 783, 785, 789,
                794, 803, 809, 815, 847, 858, 863, 863, 874, 896 ,916, 920, 926, 927, 930 ,957 ,981, 997};
        int[] b = {13, 20, 32, 35, 61, 95, 98, 98, 118, 125, 150, 194, 220, 227, 229, 246, 271, 281, 287,
                302, 307, 318, 341, 351, 354, 369, 369, 379, 380, 400, 404, 435 ,441, 442, 445, 452, 468,
                482, 489, 493, 498, 501, 504, 529, 540, 556, 568, 571, 587, 587, 602, 619, 620, 625, 652,
                653, 676, 677, 684, 690, 709, 710, 716, 724, 730, 733, 740, 755, 757, 765, 765, 772, 796,
                797, 830, 842, 847, 857, 866, 872, 903, 915, 922, 928, 933, 966, 988
        };
        int sum = object.maxPath(a,b,84,87);
        System.out.println(sum);
    }

    private int maxPath(int[] a, int[] b, int l1, int l2) {

        int sum1 = 0, sum2 = 0, sum = 0;
        int i = 0;
        int limit = l1;
        if(limit > l2){
            limit = l2;
        }

        for ( ; i < limit; i++) {
            sum1 += a[i];
            sum2 += b[i];
            if(a[i] == b[i]){
                if(sum1 > sum2) {
                    sum += sum1;
                }else {
                    sum += sum2;
                }
                sum1 = 0;
                sum2 = 0;
            }
        }

        if(l1 == l2 && i == l1){
            if(sum1 > sum2) {
                sum += sum1;
            }else {
                sum += sum2;
            }
        }else if(i < l1){
            while(i<l1){
                sum1 += a[i++];
            }
            if(sum1 > sum2){
                sum += sum1;
            }else{
                sum += sum2;
            }
        }else if(i < l2){
            while(i<l2){
                sum2 += b[i++];
            }
            if(sum1 > sum2){
                sum += sum1;
            }else{
                sum += sum2;
            }
        }
        return sum;
    }
}
