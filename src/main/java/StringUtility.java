/**
 * Created by srawa5 on 5/17/2017.
 */
public class StringUtility {

    public static int largestPalindromicSubsequence(String input) {


        int stringLength = input.length() - 1;
        int length = largestPalindromicSubsequence(input.toCharArray(), 0, stringLength);
        return length;
    }

    public static int largestPalindromicSubsequenceWithDP(String input) {


        int stringLength = input.length();
        int[][] arr = new int[stringLength][stringLength];
        for (int i = 0; i < stringLength; i++) {
            arr[i][i] = 1;
        }
        int length = largestPalindromicSubsequenceWithDP(input.toCharArray(), 0, stringLength-1, arr);
        return length;
    }

    private static int largestPalindromicSubsequenceWithDP(char[] chars, int i, int len, int[][] arr) {

          //  System.out.println("i is "+ i + " and l is "+ len);
        if (i < len) {
            if (chars[i] == chars[len]) {
                if (arr[i + 1][len - 1] == 0) {
                    arr[i + 1][len - 1] = largestPalindromicSubsequenceWithDP(chars, i + 1, len - 1,arr);
                }
                arr[i][len] = 2 + arr[i + 1][len - 1];
                return arr[i][len];
            } else {

                arr[i + 1][len] = largestPalindromicSubsequenceWithDP(chars, i + 1, len,arr);
                arr[i][len - 1] = largestPalindromicSubsequenceWithDP(chars, i, len - 1,arr);

                return Math.max(arr[i + 1][len], arr[i][len - 1]);
            }
        }

        return 0;
    }

    private static int largestPalindromicSubsequence(char[] chars, int i, int len) {


        if (i < len) {

            if (chars[i] == chars[len]) {
                return 2 + largestPalindromicSubsequence(chars, i + 1, len - 1);
            } else {
                return Math.max(largestPalindromicSubsequence(chars, i + 1, len), largestPalindromicSubsequence(chars, i, len - 1));
            }
        } else if (i == len) {
            return 1;
        }

        return 0;
    }

}
