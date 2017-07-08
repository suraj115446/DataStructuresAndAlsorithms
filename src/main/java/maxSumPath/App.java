package maxSumPath;

/**
 * Created by Suraj on 7/6/2017.
 */
public class App {

    public static void main(String[] args) {

        int n = 18;
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = j + 1;
            }
        }

        int result = 0;

        long start = System.currentTimeMillis();
        result = calculate(arr, n, 0, 0);
        long end = System.currentTimeMillis();
        System.out.println("Non dp: " + result);
        System.out.println("TimeTaken is " + (end - start));

        start = System.currentTimeMillis();
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
                    dp[x][y] = arr[x][y] + Math.max(dp[x - 1][y], dp[x][y - 1]);
                }

            }
            y = 0;
        }
        end = System.currentTimeMillis();
        System.out.println("dp: " + dp[n - 1][n - 1]);
        System.out.println("TimeTaken is " + (end - start));
    }

    private static int calculate(int[][] arr, int n, int x, int y) {

        if (x >= n || y >= n) {
            return 0;
        }
        return arr[x][y] + Math.max(calculate(arr, n, x + 1, y), calculate(arr, n, x, y + 1));
    }
}
