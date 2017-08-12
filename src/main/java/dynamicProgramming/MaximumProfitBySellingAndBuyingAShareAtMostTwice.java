package dynamicProgramming;

/**
 * Created by Suraj on 8/11/2017.
 */
public class MaximumProfitBySellingAndBuyingAShareAtMostTwice {

    public static void main(String[] args) {

        //int price[] = {10, 22, 5, 75, 65, 80};
        //int price[] = {2, 30, 15, 10, 8, 25, 80};
        //int price[] = {100, 30, 15, 10, 8, 25, 80};
        //int price[] = {90, 80, 70, 60, 50};
        int price[] = {1,150,90,70,2,89,100,125};

        System.out.println(recursiveMethod(price,0,price.length-1,1));

    }

    private static int recursiveMethod(int[] price, int i, int l,int count) {
        if(count>4 || i>l){
            return 0;
        }

        if(count%2==1){
           return Math.max(recursiveMethod(price, i+1, l, count+1)-price[i],recursiveMethod(price, i+1, l, count));
        } else {
           return Math.max(price[i]+recursiveMethod(price, i+1, l, count+1),recursiveMethod(price, i+1, l, count));

        }
    }

}
