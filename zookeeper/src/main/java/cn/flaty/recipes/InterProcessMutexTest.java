package cn.flaty.recipes;

import cn.flaty.ZKProperties;
import cn.hutool.core.lang.Holder;
import cn.hutool.core.thread.ThreadUtil;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author flaty-hp
 * @date 2020/5/16
 */
public class InterProcessMutexTest extends ZKProperties {

    public void start() throws InterruptedException {
        Holder<Integer> sum = Holder.of(0);
        int threadSize = 10;
        int size = 200;
        InterProcessMutex interProcessMutex = new InterProcessMutex(super.getAndStartClient(), "/flaty/mutex");
        ExecutorService es = Executors.newFixedThreadPool(threadSize);
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            es.execute(() -> {
                try {
                    interProcessMutex.acquire();
                    System.out.println("thread:"+Thread.currentThread().getName() +" get lock");
                    sum.set(sum.get() + 1);
                    ThreadUtil.sleep(10, TimeUnit.MINUTES);
                    interProcessMutex.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println(sum);
    }


    public static void main(String[] args) throws InterruptedException {
        new InterProcessMutexTest().start();

    }


}

