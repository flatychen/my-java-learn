package singleton;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author flaty-hp
 * @date 2020/3/10
 */
public class SyncSingleton {


    private static  SyncSingleton doubleCheck = null;

    private SyncSingleton() {

    }

    public static SyncSingleton getInstance() {
        if (doubleCheck == null) {// 两个线程可以同时进入。并在sync加锁。第二个线程会排队
            synchronized (SyncSingleton.class) {
                doubleCheck = new SyncSingleton();// 有bug、第二个线程会重新初始化?如何解决？
            }
        }
        return doubleCheck;
    }

    public static void main(String[] args) throws IOException {
        ExecutorService es = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 1000; i++) {
            es.execute(() -> System.out.println(SyncSingleton.getInstance().toString()));
        }
        System.in.read();
    }
}

