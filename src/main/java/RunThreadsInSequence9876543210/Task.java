package RunThreadsInSequence9876543210;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

/**
 * Created by Suraj on 6/26/2017.
 */
public class Task implements Callable<String> {

    private volatile int max =10;
    private final Lock lock;

    public Task(Lock lock) {
        this.lock = lock;
    }

    @Override
    public String call() throws Exception {
        String name = Thread.currentThread().getName();
        int num = Integer.parseInt(name.substring(14, name.length()));
        String result = null;

        if(max != num){
            lock.lock();
        }

        result = name;
        max--;
        lock.unlock();
        return result;
    }
}
