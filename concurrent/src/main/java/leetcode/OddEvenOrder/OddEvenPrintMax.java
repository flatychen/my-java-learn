package leetcode.OddEvenOrder;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class OddEvenPrintMax {


    Semaphore evenSem = new Semaphore(1);
    Semaphore oddSem = new Semaphore(0);

    int max = 4;

    @SneakyThrows
    public void printOdd() {
        for (int i = 1; i <= max; i=i+2) {
            oddSem.acquire();
            System.out.println("奇：" + i);
            evenSem.release();

        }
    }

    @SneakyThrows
    public void printEven() {
        for (int i = 0; i <= max;i=i+2) {
            evenSem.acquire();
            System.out.println("偶：" + i);
            oddSem.release();
        }
    }


    public static void main(String[] args) {
        OddEvenPrintMax oddEvenPrint3 = new OddEvenPrintMax();
        new Thread(oddEvenPrint3::printEven).start();
        new Thread(oddEvenPrint3::printOdd).start();
    }
}
