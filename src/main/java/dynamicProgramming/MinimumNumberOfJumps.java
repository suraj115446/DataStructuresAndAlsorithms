package dynamicProgramming;

/**
 * Created by Suraj on 7/22/2017.
 */
public class MinimumNumberOfJumps {

    public static void main(String[] args) {

        //int[] array = new int[]{1,1,2,3,4};
        //int[] array = new int[]{1,3,5,8,9,2,6,7,6,8,9};
        int[] array = new int[]{1,3,6,3,2,3,6,8,9,5};

        Integer count = 0;
        System.out.println(recursiveSolution(array,0,array.length-1, count));

    }

    private static int recursiveSolution(int[] array, int i, int l, int count) {
        if(i>l)
        return count;

        if(i+array[i]>=l){
            return count+1;
        } else {

            return Math.max(recursiveSolution(array,i+1,l,count),recursiveSolution(array,i+1,l,count+1));
        }
    }

}
