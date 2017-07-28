package arrays;

import java.util.*;

/**
 * Created by srawa5 on 7/28/2017.
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] array = new int[]{8,1,9,6,2,3,5,7};

        quickSort(array,0,array.length-1);

       for(int i: array){
           System.out.println(i);
       }

    }

    private static void quickSort(int[] array, int i, int l) {

        if(i<l){

            int p =  partition(array,i,l);

            quickSort(array,0,p-1);
            quickSort(array,p+1,l);

        }

    }

    private static int partition(int[] array, int i, int l) {

        int pivot = array[l];
        int r=l;

        for(int j=i;j<l;j++){

            if(array[j]<pivot){
                swap(array,i++,j);
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
