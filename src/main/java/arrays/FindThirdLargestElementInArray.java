package arrays;

public class FindThirdLargestElementInArray {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6};

        printThreeLargestElements(array);
    }

    private static void printThreeLargestElements(int[] array) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {


            if (thirdLargest < array[i]) {
                if (secondLargest < array[i]) {
                    if (largest < array[i]) {
                        thirdLargest =secondLargest;
                        secondLargest = largest;
                        largest = array[i];
                    } else {
                        secondLargest = array[i];
                    }

                } else {
                    thirdLargest =array[i];

                }
            }

        }

        System.out.println("Largest element is: " + largest);
        System.out.println("second Largest element is: " + secondLargest);
        System.out.println("third Largest element is: " + thirdLargest);


    }

}
