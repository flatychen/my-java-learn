package juc;

import java.util.concurrent.Callable;

public class MyFutureTask<V> implements Runnable {


    private Callable<V> callable;
    private V result;
    private boolean isDone = false;

    public MyFutureTask(Callable<V> callable) {
        this.callable = callable;
    }

    public synchronized V get() throws InterruptedException {
        while (!isDone) {
            wait();
        }
        return result;
    }

    @Override
    public void run() {
        try {
            result = callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            synchronized (this) {
                isDone = true;
                notifyAll();
            }
        }


    }
}
