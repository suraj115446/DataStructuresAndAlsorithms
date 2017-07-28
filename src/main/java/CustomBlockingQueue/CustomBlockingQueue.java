package CustomBlockingQueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue<E> implements BlockingQueue<E> {

    private final int MAX_SIZE;
    private final Lock lock = new ReentrantLock();
    private final Condition fullCondition;
    private final Condition emptyCondition;
    private Queue<E> queue;

    public CustomBlockingQueue(int max_size) {
        MAX_SIZE = max_size;
        this.fullCondition = lock.newCondition();
        this.emptyCondition = lock.newCondition();
        queue = new LinkedList<>();
    }

    @Override
    public boolean add(E e) {
        lock.lock();
        try {
            while (queue.size() == MAX_SIZE) {
                fullCondition.awaitUninterruptibly();
            }
            queue.add(e);
            return true;
        } finally {
            lock.unlock();
            return false;
        }

    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public void put(E e) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == MAX_SIZE) {
                fullCondition.await();
            }
            queue.add(e);
            emptyCondition.signalAll();
        } finally {
            lock.unlock();
        }


    }

    @Override
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public E take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == 0) {
                emptyCondition.await();
            }
            E removedElement = queue.remove();
            fullCondition.signalAll();
            return removedElement;
        } finally {
            lock.unlock();

        }
    }

    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public int drainTo(Collection<? super E> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        return 0;
    }
}

