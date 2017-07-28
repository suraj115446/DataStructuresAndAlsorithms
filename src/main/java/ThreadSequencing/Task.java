package ThreadSequencing;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Task implements Runnable {

    private volatile int threadNumber = 1;
    private final Lock lock;
    private final Condition condition;
    private final int n;
    private final long max;


    Task(Lock lock, int n, long max) {
        this.lock = lock;
        condition = lock.newCondition();
        this.n = n;
        this.max = max;
    }

    public void run() {
        for (int i = Integer.parseInt(Thread.currentThread().getName()); ; ) {
            lock.lock();
            if (threadNumber != i % n) {

                while (threadNumber != i % n) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            } else {
                if (i > max) {
                    break;
                }
                System.out.println("Thread - "+Thread.currentThread().getName() + " is printing: " + i);
                i += n;
                condition.signalAll();
                threadNumber++;
                threadNumber = threadNumber % n;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
