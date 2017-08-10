package dynamicProgramming;

/**
 * Created by Suraj on 8/3/2017.
 */
public class KnapSackProblem {

    public static void main(String[] args) {
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int  W = 50;

        System.out.println(recSolution(value,weight,W,0,value.length-1));
    }

    private static int recSolution(int[] value, int[] weight, int w, int i, int l) {

        if(i>l)
        return 0;

        if(i==l){
            return value[i];
        }

        return Math.max(Math.max(recSolution(value,weight,w,i,l-1),recSolution(value,weight,w,i+1,l)),recSolution(value,weight,w,i,l)+recSolution(value,weight,w,i+1,l));

    }

}
