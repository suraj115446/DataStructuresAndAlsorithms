package dynamicProgramming;

/**
 * Created by Suraj on 7/15/2017.
 */
public class Fibbonacci {

    public static void main(String[] args) {
        int n=12;

        int []fib = new int[n];

        for(int i=0; i< n; i++){

            if(i<=1){
                fib[i]=i;
            } else {
                fib[i]=fib[i-1]+fib[i-2];
            }
        }

        System.out.println(fib[n-1]);
    }
}
