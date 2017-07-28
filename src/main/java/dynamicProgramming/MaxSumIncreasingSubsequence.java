package dynamicProgramming;

import java.util.Scanner;

/**
 * Created by Suraj on 7/8/2017.
 */
public class MaxSumIncreasingSubsequence {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();

        //int[] arr = new int[]{3, 4, 5, 10};
        int[] arr = new int[]{1,101,2,3,100,56};
        //int[][] dp = new int[n][n];


        int result = 0;
        System.out.println(calculate(arr, 0));

        long start = System.currentTimeMillis();

        long end = System.currentTimeMillis();
        //System.out.println("dp: " + dp[n - 1][n - 1]);
        System.out.println("TimeTaken is " + (end - start));
    }

    private static int calculate(int[] arr, int i) {
        if(i >= arr.length)
            return 0;

        if (i==arr.length-1) {
            return arr[i];
        }

        if (arr[i] < arr[i + 1]) {
            return arr[i] + calculate(arr, i + 1);
        }

        return Math.max(calculate(arr, i + 1), arr[i] + calculate(arr, i + 2));
    }
}
