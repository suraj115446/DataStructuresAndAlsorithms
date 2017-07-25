package dynamicProgramming;

import static java.lang.Math.min;

/**
 * Created by Suraj on 7/22/2017.
 */
public class MinCostToFillGivenWeightInBag {

    public static void main(String[] args) {

        int[] array = new int[]{4,9,15};
        int w =5;
        System.out.println(recursiveSolution(array, 1, array.length, w));
    }

    private static int recursiveSolution(int[] array, int i, int l, int weight) {

        if(i>=l){
            return 0;
        }

        if(weight==0){
            return 0;
        } else {
            if(weight <l){
                l = weight;
            }
            return Math.min(array[i-1]+recursiveSolution(array,i,l,weight-i),array[i] + recursiveSolution(array, i+1, l, weight - i-1));
        }
    }

}
