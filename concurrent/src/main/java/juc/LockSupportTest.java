package juc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

/**
 * @author flaty-hp
 * @date 2020/5/23
 */
public class LockSupportTest {


    public static void main(String[] args) throws IOException {
        Executors.newSingleThreadExecutor().execute(() -> {
            Thread.currentThread().setName("parkWithParam");
            LockSupport.park(new ArrayList<>());
        });
        Executors.newSingleThreadExecutor().execute(() -> {
            Thread.currentThread().setName("parkNoParam");
            LockSupport.park();
        });
        System.in.read();
    }
}

