package juc;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<V> {
    private Queue<V> queue = new LinkedList<>();


    private int max = 0;

    public MyQueue(int max) {
        this.max = max;
    }

    public synchronized void put(V v) throws InterruptedException {
        while (queue.size() == max) {
            wait();
        }
        queue.add(v);
        notifyAll();
    }
    public synchronized V take() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        notifyAll();
        return queue.poll();
    }

    public static void main(String[] args) throws InterruptedException {
        MyQueue<Integer> queue = new MyQueue<>(2);
        queue.put(1);
        queue.put(12);
//        queue.put(13);
    }
}
