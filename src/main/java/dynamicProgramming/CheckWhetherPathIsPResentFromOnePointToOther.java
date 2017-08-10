package dynamicProgramming;

/**
 * Created by Suraj on 8/10/2017.
 */
public class CheckWhetherPathIsPResentFromOnePointToOther {

    public static void main(String[] args) {

        Point pi = new Point(5, 5);
        Point pf = new Point(10, 10);
        Point increment = new Point(5, 5);

        int[][] dp = new int[pf.getX() + 1][pf.getY() + 1];

        long start = System.currentTimeMillis();

        for (int x = 0; x <= pf.getX(); x += increment.getX()) {
            for (int y = 0; y <= pf.getY(); y += increment.getY()) {
                if (x < pi.getX() || y < pi.getY()) {
                    dp[x][y] = 0;
                } else {
                    if (x == pi.getX() && y == pi.getY()) {
                        dp[x][y] = 1;
                    } else if (x == pi.getX() && y != pi.getY()) {
                        dp[pi.getX()][y] = dp[pi.getX()][y - increment.getY()];
                    } else if (y == pi.getY() && x != pi.getX()) {
                        dp[x][pi.getY()] = dp[x - increment.getX()][pi.getY()];
                    } else if (x != pi.getX() && y != pi.getY()) {
                        dp[x][y] = dp[x - increment.getX()][y] + dp[x][y - increment.getY()];
                    }
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(dp[pf.getX()][pf.getY()] > 0 ? "Total Paths Possible are: " + dp[pf.getX()][pf.getY()] : "Path not possible");
        System.out.println("TimeTaken is " + (end - start));
    }

    private static class Point {

        private final int x;
        private final int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

}
