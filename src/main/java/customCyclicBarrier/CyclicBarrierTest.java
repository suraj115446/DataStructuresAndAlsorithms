package customCyclicBarrier;

/**
 * Created by Suraj on 7/9/2017.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("Hello Guys");
        CustomCyclicBarrier customCyclicBarrier = new CustomCyclicBarrier(6, runnable);
        Task task1 = new Task(customCyclicBarrier);
        Task task2 = new Task(customCyclicBarrier);
        Task task3 = new Task(customCyclicBarrier);
        Task task4 = new Task(customCyclicBarrier);
        Task task5 = new Task(customCyclicBarrier);
        Task task6 = new Task(customCyclicBarrier);

        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();
        new Thread(task4).start();
        new Thread(task5).start();
        new Thread(task6).start();

    }

}
