package leetcode.orderABC;

import lombok.SneakyThrows;

public class Abc {


    private static int max = 3;
    private static int stage = 0;

    @SneakyThrows
    public void printA()  {
        for (int i = 0; i < max; i++) {
            synchronized (Abc.class) {
                while (stage % 3 != 0) {
                    Abc.class.wait();
                }
                System.out.println("a");
                stage++;
                Abc.class.notifyAll();
            }
        }
    }
    @SneakyThrows
    public void printB()  {
        for (int i = 0; i < max; i++) {
            synchronized (Abc.class) {
                while (stage % 3 != 1) {
                    Abc.class.wait();
                }
                System.out.println("b");
                stage++;
                Abc.class.notifyAll();
            }
        }
    }
    @SneakyThrows
    public void printC()  {
        for (int i = 0; i < max; i++) {
            synchronized (Abc.class) {
                while (stage % 3 != 2) {
                    Abc.class.wait();
                }
                System.out.println("c");
                stage++;
                Abc.class.notifyAll();
            }
        }
    }




    public static void main(String[] args) {
        Abc abc = new Abc();
        new Thread(() -> abc.printA()).start();
        new Thread(() -> abc.printB()).start();
        new Thread(() -> abc.printC()).start();
    }
}
