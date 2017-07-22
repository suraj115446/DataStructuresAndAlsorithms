package dynamicProgramming;

/**
 * Created by Suraj on 7/22/2017.
 */
public class CuttingRodProblem {

    public static void main(String[] args) {


        int[] array = new int[]{3,5,8,9,10,17,17,20};
        System.out.println(recursiveSolution(array, 1, array.length, 1));


    }

    private static int recursiveSolution(int[] array, int i, int l, int k) {

        if (i > l)
            return 0;

        if (k == l) {
            return array[k-1];
        } else {
            return Math.max(array[i-1] + recursiveSolution(array, i, l - 1, k), recursiveSolution(array, i, l, k + 1));
        }


    }


}
