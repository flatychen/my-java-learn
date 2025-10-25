package singleton;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author flaty-hp
 * @date 2020/3/10
 */
public class Singleton {


    private static Singleton doubleCheck = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (doubleCheck == null) {// 高并发，存在线程安全问题
            doubleCheck = new Singleton();
        }
        return doubleCheck;
    }

    public static void main(String[] args) throws IOException {
        ExecutorService es = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 1000; i++) {
            es.execute(() -> System.out.println(Singleton.getInstance().toString()));
        }
        System.in.read();

    }
}

