package CustomBlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Suraj on 6/30/2017.
 */
public class App {

    public static void main(String[] args) {


    BlockingQueue<String> blockingQueue = new CustomBlockingQueue<String>(10);

    Producer producer = new Producer(blockingQueue);
    Consumer consumer = new Consumer(blockingQueue);

        Thread producerThread1 = new Thread(producer);
        producerThread1.start();

        Thread producerThread2 = new Thread(producer);
        producerThread2.start();

        Thread producerThread3 = new Thread(producer);
        producerThread3.start();

        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
        Thread consumerThread2 = new Thread(consumer);
        consumerThread2.start();
        Thread consumerThread3 = new Thread(consumer);
        consumerThread3.start();


    }

}
