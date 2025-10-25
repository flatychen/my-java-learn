package leetcode.ZeroEvenOdd;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class ZeroEvenOddSem {
    Semaphore zeroSem = new Semaphore(1);
    Semaphore oddSem = new Semaphore(0);
    Semaphore evenSem = new Semaphore(0);

    int max = 11;

    @SneakyThrows
    public void printZero() {
        for (int i = 0; i < max; i++) {
            zeroSem.acquire();
            System.out.println("0：" + 0);
            if (i % 2 == 1) {
                evenSem.release();
            } else {
                oddSem.release();
            }

        }
    }

    @SneakyThrows
    public void printEven() {
        for (int i = 2; i <= max; i = i + 2) {
            evenSem.acquire();
            System.out.println("偶：" + i);
            zeroSem.release();
        }
    }

    @SneakyThrows
    public void printOdd() {
        for (int i = 1; i <= max; i = i + 2) {
            oddSem.acquire();
            System.out.println("奇：" + i);
            zeroSem.release();
        }
    }


    public static void main(String[] args) {
        ZeroEvenOddSem zeroEvenOdd = new ZeroEvenOddSem();
        new Thread(zeroEvenOdd::printEven).start();
        new Thread(zeroEvenOdd::printOdd).start();
        new Thread(zeroEvenOdd::printZero).start();
    }
}
