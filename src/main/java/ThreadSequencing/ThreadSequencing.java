package ThreadSequencing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Suraj on 7/10/2017.
 */
public class ThreadSequencing {

    public static void main(String[] args) {

        ReentrantLock lock= new ReentrantLock();
        int n = 7;
        long max = 30;
        Task task = new Task(lock, n, max);
        List<Thread> threadList= new ArrayList<>();

        for(int i=1; i<=n;i++){
            threadList.add(new Thread(task, ""+i));
        }

        threadList.forEach(thread -> thread.start());

    }

}
