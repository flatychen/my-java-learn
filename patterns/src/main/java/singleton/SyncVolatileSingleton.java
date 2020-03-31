package singleton;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author flaty-hp
 * @date 2020/3/10
 */
public class SyncVolatileSingleton {


    private static volatile SyncVolatileSingleton doubleCheck = null;

    private SyncVolatileSingleton() {

    }

    public static SyncVolatileSingleton getInstance() {
        if (doubleCheck == null) {// 尽管加了volatile，两个线程扔然可以同时进入。并在sync加锁。第二个排队，本质上是没有进行第二次检查
            synchronized (SyncVolatileSingleton.class) {
                doubleCheck = new SyncVolatileSingleton();// 有bug、第二个线程会重新初始化?如何解决？
            }
        }
        return doubleCheck;
    }

    public static void main(String[] args) throws IOException {
        ExecutorService es = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 1000; i++) {
            es.execute(() -> System.out.println(SyncVolatileSingleton.getInstance().toString()));
        }
        System.in.read();
    }
}

