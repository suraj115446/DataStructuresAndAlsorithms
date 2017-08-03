package dynamicProgramming;

/**
 * Created by Suraj on 8/2/2017.
 */
public class CountNumberOFWaysToReachAGivenScore {

    public static void main(String[] args) {

        int[] array = new int[]{3,5,10};

        int score= 60;

        int[] dp = new int[21];

        for(int i=0;i<array[0];i++){
            dp[i] = 0;
        }
        dp[array[0]]=1;

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
