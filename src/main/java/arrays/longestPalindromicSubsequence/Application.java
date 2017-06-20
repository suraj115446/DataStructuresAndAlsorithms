package arrays.longestPalindromicSubsequence;

/**
 * Created by srawa5 on 4/25/2017.
 */
public class Application {

    public static void main(String[] args) {

        // binaryTreeQuestions();


        String input = "gfhghgfhhfhgf";
        long start = System.currentTimeMillis();
        System.out.println("N is: " + input.length());
        System.out.println(StringUtility.largestPalindromicSubsequenceWithDP(input));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        System.out.println(StringUtility.largestPalindromicSubsequence(input));
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }


}
