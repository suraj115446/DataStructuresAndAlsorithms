package dynamicProgramming;

/**
 * Created by Suraj on 7/27/2017.
 */
public class MaxSumOfSubMatrix {


    public static void main(String[] args) {
        int orderOfMatrix = 5;
        int[][] matrix = new int[orderOfMatrix][orderOfMatrix];

        matrix[0][0] = 1;

        for (int i = 0; i < orderOfMatrix; i++) {
            for (int j = 0; j < orderOfMatrix; j++) {
                if (i == 0 && j == 0) {
                    matrix[i][j] = 1;
                } else if (j == 0 && i != 0) {
                    matrix[i][j] = matrix[j][i];
                } else {
                    matrix[i][j] = matrix[i][j - 1] + 5 - 2 * j;
                }
            }


        }

        for (int i = 0; i < orderOfMatrix; i++) {
            for (int j = 0; j < orderOfMatrix; j++) {
                System.out.print(matrix[i][j] + "     ");
            }
            System.out.println();
        }

        int n = 4;

        int max = Integer.MIN_VALUE;

        int[][] sum = new int[orderOfMatrix + 1 - n][orderOfMatrix + 1 - n];
        int sumOfFirstSubArray =0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumOfFirstSubArray += matrix[i][j];
            }
        }

        for (int i = 0; i <= orderOfMatrix - n; i++) {
            for (int j = 0; j <= orderOfMatrix - n; j++) {
                if (i == 0 && j == 0) {
                    sum[i][j] = sumOfFirstSubArray;

                } else if (j != 0) {
                    int sumOfnthColum = 0;
                    for (int k = 0; k < n; k++) {
                        sumOfnthColum += matrix[i + k][j + n - 1] - matrix[i + k][j - 1];
                    }
                    sum[i][j] = sum[i][j - 1] + sumOfnthColum;
                } else if (i != 0) {
                    int sumOfnthRow = 0;
                    for (int k = 0; k < n; k++) {
                        sumOfnthRow += matrix[i + n - 1][j + k] - matrix[i - 1][j + k];
                    }
                    sum[i][j] = sum[i - 1][j] + sumOfnthRow;


                }
                if (max < sum[i][j]) {
                    max = sum[i][j];
                }
            }
        }

        System.out.println("SubArray Of Size " + n + " With max sum is :" + max);
    }

}
