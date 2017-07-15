package dynamicProgramming;

/**
 * Created by Suraj on 7/14/2017.
 */
public class Longestcommomsubsequence {

    public static void main(String[] args) {

        String src = "ABCDGHEFGHIJKLMNO";
        String check = "ABCDGHEFGHIJKLMNO";

        char[] strArr = src.toCharArray();
        char[] checkArr = check.toCharArray();

        System.out.println(method(strArr, checkArr, 0, 0, src.length() - 1, check.length() - 1));

        int[][] matrix = new int[strArr.length][checkArr.length];


        for (int i = 0; i < src.length(); i++) {

            for (int j = 0; j < check.length(); j++) {

                if (i == 0 && j == 0) {
                    if (strArr[i] == checkArr[j]) {
                        matrix[i][j] = 1;
                    }
                } else if (i != 0 && j == 0) {
                    matrix[i][j] = matrix[i - 1][j];
                } else if (j != 0 && i == 0) {
                    matrix[i][j] = matrix[i][j - 1];
                } else {
                    if (strArr[i] == checkArr[j]) {
                        matrix[i][j] = 1 + matrix[i-1][j-1];
                    } else {
                        matrix[i][j] = Math.max(Math.max(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]);
                    }
                }

            }
        }


        System.out.println(matrix[src.length() - 1][check.length() - 1]);


    }

    private static int method(char[] first, char[] second, int i, int j, int il, int jl) {

        if (i > il || j > jl) {
            return 0;
        }

        if (first[i] == second[j]) {
            return 1 + method(first, second, i + 1, j + 1, il, jl);
        } else {
            return Math.max(Math.max(method(first, second, i + 1, j, il, jl), method(first, second, i + 1, j + 1, il, jl)), method(first, second, i, j + 1, il, jl));
        }


    }


}
