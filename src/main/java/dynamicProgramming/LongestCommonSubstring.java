package dynamicProgramming;

public class LongestCommonSubstring {

    public static void main(String[] args) {
/*        char[] str1 = "GeeksforGeeks".toCharArray();
        char[] str2 = "GeeksQuiz".toCharArray();*/

        char[] str1 = "abcdxyz".toCharArray();
        char[] str2 = "xyzabcd".toCharArray();

/*        char[] str1 = "zxabcdezy".toCharArray();
        char[] str2 = "yzabcdezx".toCharArray();*/

        System.out.println(recursiveMethod(str1,str2,0,str1.length-1,0,str2.length-1));

    }

    private static int recursiveMethod(char[] str1, char[] str2, int i1, int l1, int i2, int l2) {

        if(i1>l1 || i2>l2){
            return 0;
        }

        if(str1[i1]==str2[i2]){
            return recursiveMethod(str1, str2, i1+1, l1, i2+1, l2)+1;
        }else{
            return Math.max(Math.max(recursiveMethod(str1, str2, i1, l1, i2+1, l2),recursiveMethod(str1, str2, i1+1, l1, i2, l2)),recursiveMethod(str1, str2, i1+1, l1, i2+1, l2));
        }
    }

}
