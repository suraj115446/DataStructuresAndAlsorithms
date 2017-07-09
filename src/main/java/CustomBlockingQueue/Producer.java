package CustomBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Suraj on 6/30/2017.
 */
public class Producer implements Runnable{

    private final BlockingQueue<String> blockingQueue;
    private final AtomicLong i;
    private final Lock lock;

    public Producer(BlockingQueue<String> blockingQueue) {

        this.blockingQueue = blockingQueue;
        i = new AtomicLong(0);
        lock = new ReentrantLock();
    }

    @Override
    public void run() {

        while(true){
            lock.lock();
            try {
                blockingQueue.put(""+ i.get());
                System.out.println("Producer thread - "+ Thread.currentThread().getName() +" produced : "+i);
                Thread.sleep(100);
            } catch (InterruptedException e) {System.out.println(Thread.currentThread().getName() + "is interrupted");
            }

            i.incrementAndGet();
            lock.unlock();

        }

    }
}
