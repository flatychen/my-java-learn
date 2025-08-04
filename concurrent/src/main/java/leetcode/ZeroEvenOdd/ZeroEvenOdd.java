package leetcode.ZeroEvenOdd;

import lombok.SneakyThrows;

public class ZeroEvenOdd {

    int max = 4;

    boolean needPrintZero = true;

    int state = 1;

    // 0 1 0 2 0 3
    @SneakyThrows
    public synchronized void printZero() {
        for (int i = 0; i < max; i ++) {
            while (!needPrintZero) {
                wait();
            }
            System.out.println("0：" + 0);
            needPrintZero = false;
            notifyAll();
        }
    }

    @SneakyThrows
    public synchronized void printEven() {
        for (int i = 2; i <= max; i = i + 2) {
            while (needPrintZero || state % 2 != 0) {
                wait();
            }
            System.out.println("偶：" + state);
            state++;
            needPrintZero = true;
            notifyAll();
        }
    }

    @SneakyThrows
    public synchronized void printOdd() {
        for (int i = 1; i <= max; i = i + 2) {
            while (needPrintZero || state % 2 != 1) {
                wait();
            }
            System.out.println("奇：" + state);
            state++;
            needPrintZero = true;
            notifyAll();
        }
    }


    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd();
        new Thread(zeroEvenOdd::printEven).start();
        new Thread(zeroEvenOdd::printZero).start();
        new Thread(zeroEvenOdd::printOdd).start();
    }
}
