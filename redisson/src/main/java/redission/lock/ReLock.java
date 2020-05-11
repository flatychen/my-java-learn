package redission.lock;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import redission.RedisConfig;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author flaty-hp
 * @date 2020/4/6
 */
@Slf4j
public class ReLock extends RedisConfig {


    private static ExecutorService es = Executors.newFixedThreadPool(4);

    private int i = 1;

    private static int max_loop = 50;

    public static void main(String[] args) throws IOException {
        ReLock reLock = new ReLock();
        for (int i = 0; i < max_loop; i++) {
            es.execute(() -> reLock.start());
        }
        System.in.read();
    }

    private void start() {
        Lock lock = super.getClient().getLock("ReLock");
        lock.lock();
        try {
            log.info(" i: {}",i++);
            ThreadUtil.sleep(15, TimeUnit.SECONDS);
        } finally {
            lock.unlock();
        }

    }
}

