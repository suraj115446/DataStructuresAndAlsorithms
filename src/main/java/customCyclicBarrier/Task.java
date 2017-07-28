package customCyclicBarrier;

/**
 * Created by Suraj on 7/9/2017.
 */
public class Task  implements Runnable {

    private CustomCyclicBarrier customCyclicBarrier;

    public Task(CustomCyclicBarrier customCyclicBarrier) {
        this.customCyclicBarrier = customCyclicBarrier;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+" is waiting.");
        customCyclicBarrier.await();
        System.out.println(Thread.currentThread().getName()+" is executed.");

    }
}
