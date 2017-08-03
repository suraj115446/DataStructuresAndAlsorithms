package dynamicProgramming;

/**
 * Coin Change Problem is the superset of CountNumberOFWaysToReachAGivenScore
 */
public class CountNumberOFWaysToReachAGivenScore {

    public static void main(String[] args) {

        int[] array = new int[]{1,2,3};

        int score= 4;

        System.out.println(recMethod(array,0,array.length-1,score));

    }

    private static int recMethod(int[] array, int i, int l, int score) {

        if(score==0 ){
            return 1;
        } else if(i>l || score < array[i] ){
            return 0;
        } else {
            return recMethod(array,i,l,score-array[i])+recMethod(array, i+1, l, score);
        }

    }

}
