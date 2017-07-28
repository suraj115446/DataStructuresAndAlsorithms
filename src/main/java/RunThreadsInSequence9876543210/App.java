package RunThreadsInSequence9876543210;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Suraj on 6/26/2017.
 */
public class App {

    public static void main(String[] args) throws InterruptedException {


            Lock lock = new ReentrantLock();
        Collection<Callable<String>> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Task(lock));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<String>> list = executorService.invokeAll(threadList);

        list.forEach(stringFuture -> {
            try {
                System.out.println(stringFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

    }
}
