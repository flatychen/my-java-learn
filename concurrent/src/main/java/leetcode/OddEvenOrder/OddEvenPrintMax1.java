package leetcode.OddEvenOrder;

import leetcode.orderABC.Abc;
import lombok.SneakyThrows;

public class OddEvenPrintMax1 {

    private int max = 10;
    private int stage = 0;

    @SneakyThrows
    public synchronized void printOdd() {
        for (int i = 1; i <= max; i = i + 2) {
            while (stage % 2 != 1) {
                wait();
            }
            System.out.println("奇：" + stage);
            stage++;
            notifyAll();

        }
    }

    @SneakyThrows
    public synchronized void printEven() {
        for (int i = 0; i <= max; i = i + 2) {
            while (stage % 2 != 0) {
                wait();
            }
            System.out.println("偶：" + stage);
            stage++;
            notifyAll();

        }
    }


    public static void main(String[] args) {
        OddEvenPrintMax1 oddEvenPrint = new OddEvenPrintMax1();
        new Thread(oddEvenPrint::printEven).start();
        new Thread(oddEvenPrint::printOdd).start();
    }
}
