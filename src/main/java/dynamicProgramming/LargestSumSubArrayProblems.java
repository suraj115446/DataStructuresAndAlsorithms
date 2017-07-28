package dynamicProgramming;

/**
 * Created by Suraj on 7/15/2017.
 */
public class LargestSumSubArrayProblems {

    public static void main(String[] args) {

        int[] array = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};

        int maxSum = 0;
        int largestSum = 0;

        for (int i = 0; i < array.length; i++) {

            maxSum += array[i];

            if (maxSum < 0) {
                maxSum = 0;
            } else if (largestSum < maxSum) {
                largestSum = maxSum;
            }

        }

        System.out.println(largestSum);


    }

}
