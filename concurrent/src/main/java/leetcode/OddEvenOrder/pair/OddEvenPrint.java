package leetcode.OddEvenOrder.pair;

import leetcode.orderABC.Abc;
import lombok.SneakyThrows;

public class OddEvenPrint {

    private  int maxPair = 5;
    private  int stage = 0;

    @SneakyThrows
    public void printOdd() {
        for (int i = 0; i < maxPair; i++) {
            synchronized (Abc.class) {
                while (stage % 2 != 1) {
                    Abc.class.wait();
                }
                System.out.println("奇：" + stage);
                stage++;
                Abc.class.notifyAll();
            }
        }
    }

    @SneakyThrows
    public void printEven() {
        for (int i = 0; i < maxPair; i++) {
            synchronized (Abc.class) {
                while (stage % 2 != 0) {
                    Abc.class.wait();
                }
                System.out.println("偶：" + stage);
                stage++;
                Abc.class.notifyAll();
            }
        }
    }


    public static void main(String[] args) {
        OddEvenPrint oddEvenPrint = new OddEvenPrint();
        new Thread(oddEvenPrint::printEven).start();
        new Thread(oddEvenPrint::printOdd).start();
    }
}
