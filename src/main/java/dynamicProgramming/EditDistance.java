package dynamicProgramming;

/**
 * Created by Suraj on 8/10/2017.
 */
public class EditDistance {

    public static void main(String[] args) {

        char[] str1 = "sunday".toCharArray();
        char[] str2 = "saturday".toCharArray();

        System.out.println(recursiveMethod(str1, str2, 0, str1.length - 1, 0, str2.length - 1));
    }

    private static int recursiveMethod(char[] str1, char[] str2, int i1, int l1, int i2, int l2) {

        if (i1 >= l1 || i2 >= l2) {
            return 0;
        }
        if (str1[i1] == str2[i2]) {
            return recursiveMethod(str1, str2, i1 + 1, l1, i2 + 1, l2);
        } else {
            return Math.min(Math.min(recursiveMethod(str1, str2, i1, l1, i2 + 1, l2), recursiveMethod(str1, str2, i1 + 1, l1, i2, l2)), recursiveMethod(str1, str2, i1 + 1, l1, i2 + 1, l2)) + 1;
        }

    }

}
