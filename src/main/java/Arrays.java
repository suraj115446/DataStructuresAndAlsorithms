import TaskOfThrowingDice.DummyClass;
import TaskOfThrowingDice.Task;

/**
 * Created by Suraj on 4/26/2017.
 */
public class Arrays {

    private static void slidingWindowMaximum() {
        int[] arr = {8,5,10,7,9,4,15,12,90,13};
        int k = 4;

        //int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        //int k=3

        int i = 0;
        int n = arr.length - 1;

        int max = arr[i];
        while (i <= n) {

            if (arr[i] > max) {
                max = arr[i];
            }
            if (i >= k - 1)
                System.out.println("max is : " + max);

            i++;
        }
    }

    private static void ocpjpThreadProblem() {
        Task task = new Task(new DummyClass());
        Thread thread1 = new Thread(task, "Joe");
        Thread thread2 = new Thread(task, "Jack");

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void findMaxOfDiffOfjAndiSuchThatArrJGreaterthanArrI() {
        int[] arr = {6, 5, 4, 3, 2, 1};
        //int[] arr= {1,2,3,4,5,6};
        //int[] arr= {34,8,10,3,2,80,30,33,1};
        //int[] arr= {9,2,3,4,5,6,7,8,18,0};

        int l = arr.length - 1;

        int i = 0;
        int j = l;

        int max = j - i;

        while (i < j) {
            if (arr[j] < arr[j - 1]) {
                j--;
            } else {
                break;
            }
        }

        int max_so_far_from_right = arr[j];

        while (i <= j) {
            if (arr[i] > max_so_far_from_right) {
                i++;
            } else {
                break;
            }
        }

        System.out.println(j + " is j and " + " i is " + i + " max is : " + (j - i));
    }
}
