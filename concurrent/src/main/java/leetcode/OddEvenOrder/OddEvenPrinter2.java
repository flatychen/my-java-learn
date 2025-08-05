package leetcode.OddEvenOrder;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinter2 {
    private final int MAX = 10;
    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition con = lock.newCondition();

    public static void main(String[] args) {
        OddEvenPrinter2 oddEvenPrinter2 = new OddEvenPrinter2();
        new Thread(() -> oddEvenPrinter2.printOdd()).start();
        new Thread(() -> oddEvenPrinter2.printEven()).start();
    }

    @SneakyThrows
    private void printOdd() {
        lock.lock();
        try {
            while (num <= MAX) {
                if (num % 2 == 1) {
                    System.out.println("odd: " + num++);
                    con.signalAll();
                } else {
                    con.await();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    @SneakyThrows
    private void printEven() {
        lock.lock();
        try {
            while (num <= MAX) {
                if (num % 2 == 0) {
                    System.out.println("even: " + num++);
                    con.signalAll();
                } else {
                    con.await();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}