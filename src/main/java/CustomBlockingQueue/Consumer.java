package CustomBlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Suraj on 6/30/2017.
 */
public class Consumer implements Runnable {


    private BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {

        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {


            try {
                System.out.println("ConsumerThread - "+ Thread.currentThread().getName() +" consumed: "+blockingQueue.take());
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "is interrupted");
            }
        }

    }
}
