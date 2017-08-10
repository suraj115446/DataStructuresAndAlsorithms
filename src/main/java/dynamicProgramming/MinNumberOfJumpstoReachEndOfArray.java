package dynamicProgramming;

/**
 * Created by srawa5 on 8/2/2017.
 */
public class MinNumberOfJumpstoReachEndOfArray {

    public static void main(String[] args) {

        int[] array = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        System.out.println(method(array,0,array.length-1,0));

    }

    private static int method(int[] array, int i, int l,int c) {

        if(i>l)
            return Integer.MAX_VALUE;
        else if(i==l)
            return c;

        int min=c;
        int result =c;
        for(int j=1;j<=array[i];j++){
            result =method(array, i+j, l, c+1);
            if(min>result){
                min = result;
            }
        }

        return min;
    }

}
