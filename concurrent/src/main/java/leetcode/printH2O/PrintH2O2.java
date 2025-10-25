package leetcode.printH2O;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class PrintH2O2 {

    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(0);
    int max = 15;
    int i = 0;

    @SneakyThrows
    public  void hydrogen() {
        while (i < max) {
            h.acquire();
            System.out.print("H");
            o.release();
        }

    }

    @SneakyThrows
    public  void oxygen() {
        while (i < max) {
            o.acquire(2);
            System.out.println("O");
            i++;
            h.release(2);
        }
    }


    public static void main(String[] args) {
        PrintH2O2 printH2O = new PrintH2O2();
        new Thread(() -> {
            printH2O.hydrogen();
        }).start();
        new Thread(() -> {
            printH2O.oxygen();
        }).start();
    }
}
