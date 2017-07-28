package arrays;

/**
 * Created by srawa5 on 7/28/2017.
 */
public class FindKthsmallestelementInArray {

    public static void main(String[] args) {

        int[] array = new int[]{8, 1, 9, 6, 2, 3, 5, 7};

        System.out.println(findKthsmallestElement(array, 0, array.length - 1, 4));

    }

    private static int findKthsmallestElement(int[] array, int i, int l, int k) {

        if (i < l) {

            int pos = partition(array, i, l);

            if (pos == k - 1) {
                return array[k - 1];
            }

            if (pos < k - 1) {
                return findKthsmallestElement(array, pos + 1, l,k);
            }

            return findKthsmallestElement(array, 0, pos - 1,k);



        }

        return 0;

    }

    private static int partition(int[] array, int i, int l) {

        int pivot = array[l];
        int r = l;

        for (int j = i; j < l; j++) {

            if (array[j] < pivot) {
                swap(array, i++, j);
            }

        }

        swap(array, i, l);


        return i;
    }

    private static void swap(int[] array, int i, int l) {

        int temp = array[i];
        array[i] = array[l];
        array[l] = temp;

    }


}
