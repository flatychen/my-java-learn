package leetcode.OddEvenOrder;

import lombok.SneakyThrows;

public class OddEvenPrintMax2 {

    private int max = 5;
    private int stage = 0;

    @SneakyThrows
    public synchronized void printOdd() {
        while (stage <= max) {
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
        while (stage <= max) {
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
        OddEvenPrintMax2 oddEvenPrint = new OddEvenPrintMax2();
        new Thread(oddEvenPrint::printEven).start();
        new Thread(oddEvenPrint::printOdd).start();
    }
}
