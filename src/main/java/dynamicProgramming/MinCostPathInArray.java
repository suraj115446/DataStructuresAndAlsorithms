package dynamicProgramming;

import java.util.Scanner;

public class MinCostPathInArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the n for n x n matrix.");
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];
 /*       for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("enter matrix element ["+i+"]["+j+"]");
                arr[i][j] = scanner.nextInt();
            }
        }*/
            arr[0]= new int[]{1,2,3};
            arr[1]= new int[]{4,8,2};
            arr[2]= new int[]{1,5,3};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }

        int result = 0;

        long start = System.currentTimeMillis();
        int y = 0;
        for (int x = 0; x < n; x++) {

            for (y = 0; y < n; y++) {

                if (x == 0 && y == 0) {
                    dp[0][0] = arr[0][0];
                    continue;
                }
                if (x == 0 && y != 0) {
                    dp[0][y] = arr[0][y] + dp[0][y - 1];
                } else if (y == 0 && x != 0) {
                    dp[x][0] = arr[x][0] + dp[x - 1][0];
                } else if (x != 0 && y != 0) {
                    dp[x][y] = arr[x][y] + Math.min(Math.min(dp[x - 1][y], dp[x][y - 1]),dp[x-1][y-1]);
                }

            }
            y = 0;
        }
        long end = System.currentTimeMillis();
        System.out.println("dp: " + dp[n - 1][n - 1]);
        System.out.println("TimeTaken is " + (end - start));
    }


}
