package dynamicProgramming;


import java.util.Arrays;

import static java.lang.Math.max;
import static java.util.Arrays.fill;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        int[] array = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        //

        System.out.println(lis(array, 0, array.length - 1));

        int [] dp = new int[array.length+1];
        fill(dp,1);

        for(int i=1; i< array.length; i++){

                if(array[i-1]<array[i]){
                    dp[i] = 1+dp[i-1];
                } else {
                    dp[i] = max(max(dp[i-1],dp[i+1]),dp[i]);
                }

            }

        System.out.println(dp[array.length-1]);


    }

    private static int lis(int[] array, int i, int l) {

        if(i >=l){
            return 1;
        }

        if (array[i] < array[i+1]) {
            return 1+ lis(array,i+1,l);
        } else {
            return max(lis(array,i+1,l),lis(array,i+2,l));
        }
    }

}
