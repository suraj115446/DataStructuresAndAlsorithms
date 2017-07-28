package customCyclicBarrier;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Suraj on 7/9/2017.
 */
public class CustomCyclicBarrier {

    private final long count;
    private final Lock lock;
    private final AtomicLong tempCount;
    private Runnable runnable;
    private Thread threadAction;
    private boolean actionFlag;


    public CustomCyclicBarrier(long count, Runnable runnable) {
        this(count);
        this.runnable = runnable;
        threadAction = new Thread(runnable);

    }

    public CustomCyclicBarrier(long count) {
        this.count = count;
        lock = new ReentrantLock();
        tempCount = new AtomicLong(0);
        actionFlag = false;
    }

    public void await() {
        System.out.println(Thread.currentThread().getName() + " got into Awaited");


        tempCount.incrementAndGet();

        lock.lock();
        System.out.println(Thread.currentThread().getName() + " got Lock");

        while (true) {
            if (tempCount.get() == count) {
                releaseLock();
                if(actionFlag==false && runnable!=null){
                    threadAction.start();
                    actionFlag = true;
                }
                break;

            }
        }

    }

    private void releaseLock() {

        System.out.println(Thread.currentThread().getName() + " got released");
        lock.unlock();

    }

    public void reset(){
        tempCount.set(0l);
    }

}
