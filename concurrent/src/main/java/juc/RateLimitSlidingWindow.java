package juc;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class RateLimitSlidingWindow {

    private long windowSizeInMs = 0;
    private int limit = 0;

    private ConcurrentLinkedQueue<Long> queue = new ConcurrentLinkedQueue<>();

    public RateLimitSlidingWindow(int limit, long windowSize, TimeUnit timeUnit) {
        this.windowSizeInMs = timeUnit.toMillis(windowSize);
        this.limit = limit;
    }
    public boolean check(){
        long now = System.currentTimeMillis();
        long expire = now - windowSizeInMs;
        while (queue.peek()!=null && queue.peek() < expire) {
            queue.poll();
        }
        if (queue.size() <= limit){
            queue.offer(now);
            return true;
        }
        else return false;
    }
}
