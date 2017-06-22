package arrays.CountTotalSetBitsInAllNumbersFromFirst1tonNumbers;

/**
 * Created by srawa5 on 6/22/2017.
 */
public class App {

    public static void main(String[] args) {

        int bitcount1= getBitCountsTillGivenNumber(1);
        System.out.println(bitcount1);
    }

    private static int getBitCountsTillGivenNumber(int num) {
        int count =0;
        for(int i=0; i<=num; i++){
            count += getBitCountofGivenNumber(i);
        }
        return count;
    }


    private static int getBitCountofGivenNumber(int i) {
        int count=0;
        while(i !=0){
            count += i%2;
            i=i/2;
        }
        return count;
    }

}
