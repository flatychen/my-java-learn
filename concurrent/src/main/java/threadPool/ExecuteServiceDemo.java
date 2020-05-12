package threadPool;

import java.util.concurrent.Executors;

/**
 * @author flaty
 * @date 2020-5-5
 */
public class ExecuteServiceDemo {

    public static void main(String[] args) {
        Executors.newFixedThreadPool(2).execute(() -> {
            System.out.println("ExecuteServiceDemo");
        });
        Thread t = new Thread(() -> {
            System.out.println("daemon thread");
        });
        t.setDaemon(true);
        t.start();
    }
}

