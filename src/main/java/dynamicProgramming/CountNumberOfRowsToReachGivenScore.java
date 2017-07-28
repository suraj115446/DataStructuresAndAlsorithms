package dynamicProgramming;

/**
 * Created by Suraj on 7/25/2017.
 */
public class CountNumberOfRowsToReachGivenScore {

    private static int count=0;
    public static void main(String[] args) {

        int n=4;
        System.out.println(recursiveSolution(1,2,3,n));
        System.out.println(count);
    }

    private static int recursiveSolution(int a, int b, int c, int n) {

        if(n<0){
            return 0;
        }
        if(n==0){
            count ++;
            return 1;
        }

        int p = recursiveSolution(a, b, c, n - a);
        int q = recursiveSolution(a, b, c, n - b);
        int r = recursiveSolution(a, b, c, n - c);
        return p + q + r;
    }

}
