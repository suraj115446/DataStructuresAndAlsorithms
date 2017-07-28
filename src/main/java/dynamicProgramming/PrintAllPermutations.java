package dynamicProgramming;


/**
 * Created by Suraj on 7/28/2017.
 */
public class PrintAllPermutations {

    private static int counter=1;

    public static void main(String[] args) {
        
        char[] array = new char[]{'a', 'b', 'c', 'd'};

        permute(array, 0, array.length - 1);

    }

    private static void permute(char[] array, int i, int l) {

        if (i == l) {
            System.out.print(counter +" : ");
            counter++;
            for (char c : array) {
                System.out.print(c);
            }
            System.out.println();
        } else {
            for (int j = i; j <=l; j++) {
                swap(array, i, j);
                permute(array, i + 1, l);
                swap(array, i, j);
            }
        }
    }

    private static void swap(char[] array, int i, int l) {

        char temp = array[i];
        array[i] = array[l];
        array[l] = temp;

    }

}
