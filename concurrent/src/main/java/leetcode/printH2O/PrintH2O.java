package leetcode.printH2O;

import lombok.SneakyThrows;

import java.awt.desktop.PrintFilesHandler;

public class PrintH2O {


    int hCount = 0;
    int max = 15;
    int i = 0;

    @SneakyThrows
    public synchronized void hydrogen() {
        while (i < max) {
            while (hCount == 2) {
                wait();
            }
            if(i>=max) break;
            System.out.print("H");
            hCount++;
            notifyAll();
        }

    }

    @SneakyThrows
    public synchronized void oxygen() {
        while (i < max) {
            while (hCount != 2) {
                wait();
            }
            if(i>=max) break;
            System.out.println("O");
            i++;
            hCount = 0;
            notifyAll();
        }
    }


    public static void main(String[] args) {
        PrintH2O printH2O = new PrintH2O();
        new Thread(() -> {
            printH2O.hydrogen();
        }).start();
        new Thread(() -> {
            printH2O.oxygen();
        }).start();
    }
}
