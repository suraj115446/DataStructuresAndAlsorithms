package TaskOfThrowingDice;

import java.util.Random;

/**
 * Created by Suraj on 4/19/2017.
 */
public class Task implements Runnable {

    private DummyClass dummyClass;
    private static int counter = 0;
    private static String currentPlayerName;


    public Task(DummyClass dummyClass) {
        this.dummyClass = dummyClass;
    }

    public void run() {
        synchronized (dummyClass) {

            while (counter < 12) {
                if (currentPlayerName != null) {

                    if (currentPlayerName.equals(Thread.currentThread().getName())) {
                        try {
                            dummyClass.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    Random random = new Random();
                    System.out.println(currentPlayerName + " : throwed " + random.nextInt());
                    currentPlayerName = Thread.currentThread().getName();
                    dummyClass.notify();
                    counter++;
                } else {
                    currentPlayerName=Thread.currentThread().getName();
                }

            }
        }
    }
}
