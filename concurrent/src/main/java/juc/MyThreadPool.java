package juc;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Stream;

public class MyThreadPool {

    private int poolSize;
    private Queue<Runnable> queue = null;

    private Worker[] threads;

    public class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                Runnable task = queue.poll();
                task.run();
            }

        }
    }

    public MyThreadPool(int poolSize, int queueSize) {
        this.poolSize = poolSize;
        this.queue = new ArrayBlockingQueue(queueSize);
        for (int i = 0; i < poolSize; i++) {
            Worker worker = new Worker();
            worker.start();

        }
    }

    public void execute(Runnable task) {
        queue.offer(task);
    }


}
