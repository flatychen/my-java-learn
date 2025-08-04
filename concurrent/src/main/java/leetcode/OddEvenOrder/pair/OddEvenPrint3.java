package leetcode.OddEvenOrder.pair;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class OddEvenPrint3 {


    Semaphore oddSem = new Semaphore(1);
    Semaphore evenSem = new Semaphore(0);

    int maxPair = 3;
    int stage = 0;

    @SneakyThrows
    public void printEven() {
        for (int i = 0; i < maxPair; i++) {
            oddSem.acquire();
            System.out.println("偶：" + stage);
            stage++;
            evenSem.release();

        }
    }

    @SneakyThrows
    public void printOdd() {
        for (int i = 0; i < maxPair; i++) {
            evenSem.acquire();
            System.out.println("奇：" + stage);
            stage++;
            oddSem.release();
        }
    }


    public static void main(String[] args) {
        OddEvenPrint3 oddEvenPrint3 = new OddEvenPrint3();
        new Thread(oddEvenPrint3::printEven).start();
        new Thread(oddEvenPrint3::printOdd).start();
    }
}
