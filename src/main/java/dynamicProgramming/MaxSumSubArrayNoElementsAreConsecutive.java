package dynamicProgramming;

/**
 * Created by Suraj on 7/22/2017.
 */
public class MaxSumSubArrayNoElementsAreConsecutive {

    public static void main(String[] args) {
        int[] array = new int[]{5,50,10,20,150,100,10,4};
        //int[] array = new int[]{1,2,3};
        //int[] array = new int[]{1, 20, 3};
        int l = array.length;

        System.out.println("recursive :"+method(array, 0, l-1));

        int[] dp = new int[l];
        for (int i = 0; i < l; i++) {
            if (i < 2) {
                dp[i] = array[i];
            } else {
                dp[i] = Math.max(array[i]+dp[i-2] , dp[i-1] );
            }
        }

        System.out.println("Dynamic Programming: "+dp[l-1]);

    }

    private static int method(int[] array, int i, int l) {
        if (i >= l - 1) {
            return array[i];
        }
        return Math.max(array[i] + method(array, i + 2, l), method(array, i + 1, l));
    }

}
