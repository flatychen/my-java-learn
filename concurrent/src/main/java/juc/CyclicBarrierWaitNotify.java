package juc;

/**
 * @author flaty-hp
 * @date 2020/5/12
 */
public class CyclicBarrierWaitNotify {

    private int count = 0;

    private Object lock = new Object();

    public CyclicBarrierWaitNotify(int count) {
        if (count < 0) throw new IllegalArgumentException("count < 0");
        this.count = count;
    }


    public void await() throws InterruptedException {
        synchronized (lock) {
            count--;
            if (count == 0) {
                lock.notifyAll();
                return;
            }
            lock.wait();
        }
    }
}

