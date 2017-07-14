package substring_in_string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suraj on 7/14/2017.
 */
public class App {

    public static void main(String[] args) {
        String src= "abcdfgh" ;
        String check= "cdf";

        char [] strArr = src.toCharArray();
        char [] checkArr = check.toCharArray();
        List<Integer> list = new ArrayList<>();

        int i=0,j=0;
                int count =0;
        while(i<strArr.length-1){
            if(strArr[i]==checkArr[j]){
                count++;
                j++;
            } else {
                j=0;
            }
            i++;
            if(count==check.length()){
                list.add(i - count);
                count=0;
                j=0;
            }

        }

        list.forEach(System.out::println);

    }

}
