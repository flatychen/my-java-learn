package juc;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author flaty
 * @date 2020-5-12
 */
@Slf4j
public class CountDownLatchTest {

    public static void main(String[] args) throws IOException {
        int size = 10;
        ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ExecutorService es2 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            int finalI = i;
            es.execute(() -> {
                System.out.println("i:"+ finalI);
                countDownLatch.countDown();
            });
        }

        for (int i = 0; i < size; i++) {
            es2.execute(() -> {
                try {
                    countDownLatch.await();
                    log.info("wait success");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }



        System.in.read();
    }
}

