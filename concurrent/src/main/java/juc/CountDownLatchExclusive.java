package juc;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author flaty-hp
 * @date 2020/5/11
 */
public class CountDownLatchExclusive {

    private static final class Sync extends AbstractQueuedSynchronizer {

        Sync(int count) {
            setState(count);
        }

        int getCount() {
            return getState();
        }

        @Override
        protected boolean tryAcquire(int acquires) {
            return getState() == 0;
        }
        @Override
        protected boolean tryRelease(int releases) {
            // Decrement count; signal when transition to zero
            for (;;) {
                int c = getState();
                if (c == 0)
                    return false;
                int nextc = c-1;
                if (compareAndSetState(c, nextc))
                    return nextc == 0;
            }
        }
    }

    private final CountDownLatchExclusive.Sync sync;

    public CountDownLatchExclusive(int count) {
        if (count < 0) throw new IllegalArgumentException("count < 0");
        this.sync = new Sync(count);
    }

    public void await() {
        sync.acquire(1);
    }


    public void countDown() {
        sync.release(1);
    }

    public static void main(String[] args) {
        int threadSize = 100;
        ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CountDownLatchExclusive countDownLatchExclusive = new CountDownLatchExclusive(threadSize);
        for (int i = 0; i < threadSize; i++) {
            int finalI = i;
            es.execute(() -> {
                System.out.println("start i:" + finalI);
                ThreadUtil.sleep(100, TimeUnit.MILLISECONDS);
                countDownLatchExclusive.countDown();
            });
        }
        countDownLatchExclusive.await();
        System.out.println("main thread shutdown");

    }

}

