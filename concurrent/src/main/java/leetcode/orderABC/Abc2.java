package leetcode.orderABC;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class Abc2 {


    Semaphore aSem = new Semaphore(1);
    Semaphore bSem = new Semaphore(0);
    Semaphore cSem = new Semaphore(0);

    int max = 3;

    @SneakyThrows
    public void printA() {
        for (int i = 0; i < max; i++) {
            aSem.acquire();
            System.out.println("A：" + "A");
            bSem.release();

        }
    }

    @SneakyThrows
    public void printB() {
        for (int i = 0; i < max; i++) {
            bSem.acquire();
            System.out.println("B：" + "B");
            cSem.release();
        }
    }
    @SneakyThrows
    public void printC() {
        for (int i = 0; i < max; i++) {
            cSem.acquire();
            System.out.println("C：" + "C");
            aSem.release();
        }
    }


    public static void main(String[] args) {
        Abc2 abc2 = new Abc2();
        new Thread(abc2::printA).start();
        new Thread(abc2::printB).start();
        new Thread(abc2::printC).start();
    }
}
