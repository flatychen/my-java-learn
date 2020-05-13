package juc;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author flaty-hp
 * @date 2020/5/12
 */

@Slf4j
public class CyclicBarrierWaitNotifyTest {


    public static void main(String[] args) throws IOException {
        int threadSize = 20;
        ExecutorService es = Executors.newFixedThreadPool(20);
        CyclicBarrierWaitNotify cyc = new CyclicBarrierWaitNotify(threadSize);
        for (int i = 0; i < threadSize; i++) {
            int finalI = i;
            es.execute(() -> {
                try {
                    ThreadUtil.sleep(RandomUtil.randomInt(5), TimeUnit.SECONDS);
                    cyc.await();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                log.info("start {} thread:", finalI);
            });
        }
        System.in.read();
    }
}

