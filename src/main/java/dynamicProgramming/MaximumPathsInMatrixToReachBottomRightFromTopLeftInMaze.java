package dynamicProgramming;

import java.util.Scanner;

public class MaximumPathsInMatrixToReachBottomRightFromTopLeftInMaze {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the n for n x n matrix.");
        int n = scanner.nextInt();
        int[][] array = {{0,  0, 0, 0},
                {0, -1, 0, 0},
                {-1, 0, 0, -1},
                {0,  0, 0, 0}};
        int[][] dp = new int[n][n];
        /*
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("enter matrix element [" + i + "][" + j + "]");
                array[i][j] = i + j;
            }
        }*/

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }

        int result = 0;

        long start = System.currentTimeMillis();
        int y = 0;
        for (int x = 0; x < n; x++) {
            for (y = 0; y < n; y++) {
                if (array[x][y] == -1) {
                    dp[x][y] = 0;
                } else {
                    if (x == 0 && y == 0) {
                        dp[0][0] = 1;
                    } else if (x == 0 && y != 0) {
                        dp[0][y] = dp[0][y - 1];
                    } else if (y == 0 && x != 0) {
                        dp[x][0] = dp[x - 1][0];
                    } else if (x != 0 && y != 0) {
                        dp[x][y] = dp[x - 1][y] + dp[x][y - 1];
                    }
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("dp: " + dp[n - 1][n - 1]);
        System.out.println("TimeTaken is " + (end - start));
    }


}
