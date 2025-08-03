package leetcode.OddEvenOrder;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrint2 {


    Lock lock = new ReentrantLock();

    Condition con = lock.newCondition();
    int max = 3;
    int stage = 0;

    @SneakyThrows
    public void printOdd() {
        for (int i = 0; i < max; i++) {
            lock.lock();
            try {
                while (stage % 2 != 0) {
                    con.await();
                }
                System.out.println("偶：" + stage);
                stage++;
                con.signalAll();
            } finally {
                lock.unlock();
            }

        }
    }

    @SneakyThrows
    public void printEven() {
        for (int i = 0; i < max; i++) {
            lock.lock();
            try {
                while (stage % 2 != 1) {
                    con.await();
                }
                System.out.println("奇：" + stage);
                stage++;
                con.signalAll();
            } finally {
                lock.unlock();
            }

        }
    }


    public static void main(String[] args) {
        OddEvenPrint2 oddEvenPrint2 = new OddEvenPrint2();
        new Thread(oddEvenPrint2::printEven).start();
        new Thread(oddEvenPrint2::printOdd).start();
    }
}
