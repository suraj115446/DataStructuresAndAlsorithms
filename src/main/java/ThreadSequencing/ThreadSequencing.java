package ThreadSequencing;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Suraj on 7/10/2017.
 */
public class ThreadSequencing {

    public static void main(String[] args) {

        ReentrantLock lock= new ReentrantLock();
        Runnable task = new Task(lock, 3, 5);
        Thread thread1= new Thread(task,"1");
        Thread thread2= new Thread(task,"2");
        Thread thread3= new Thread(task,"3");

        thread1.start();
        thread2.start();
        thread3.start();

    }

}
