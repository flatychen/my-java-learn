package leetcode.printInOrder1114;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo3 {



    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int count=1;


    public Foo3() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            printFirst.run();
            count++;
            condition.signalAll();
        } finally {
            lock.unlock();
        }


    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        lock.lock();
        try {
            while (count!=2){
                condition.await();
            }
            printSecond.run();
            count++;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        lock.lock();
        try {
            while (count!=3){
                condition.await();
            }
            printThird.run();
        } finally {
            lock.unlock();
        }
    }
}
