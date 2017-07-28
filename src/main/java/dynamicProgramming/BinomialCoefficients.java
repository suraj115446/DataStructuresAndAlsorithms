package dynamicProgramming;

public class BinomialCoefficients {

    public static void main(String[] args) {
        int n = 10;
        int k = 1;

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= Math.min(i, k); j++) {

                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }

            }

        }

        System.out.println(dp[n][k]);

    }

}
