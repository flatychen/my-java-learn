package leetcode.OddEvenOrder;

import lombok.SneakyThrows;

public class OddEvenPrintMax3 {

    private int max = 6;
    private int stage = 0;

    @SneakyThrows
    public synchronized void printOdd() {
        for (int i = 1; i <= max; i=i+2) {
            while (stage % 2 != 1) {
                wait();
            }
            if (stage <= max) {
                System.out.println("奇：" + stage);
                stage++;
                notifyAll();
            }

        }
    }

    @SneakyThrows
    public synchronized void printEven() {
        for (int i = 0; i <= max; i=i+2) {
            while (stage % 2 != 0) {
                wait();
            }
            if (stage <= max) {
                System.out.println("偶：" + stage);
                stage++;
                notifyAll();
            }

        }
    }


    public static void main(String[] args) {
        OddEvenPrintMax3 oddEvenPrint = new OddEvenPrintMax3();
        new Thread(oddEvenPrint::printEven).start();
        new Thread(oddEvenPrint::printOdd).start();
    }
}
