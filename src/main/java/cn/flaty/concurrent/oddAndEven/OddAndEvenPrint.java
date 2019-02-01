package cn.flaty.concurrent.oddAndEven;

import java.io.IOException;

/**
 * 最容易想到的办法
 */
public class OddAndEvenPrint {


    private static int max = 100;


    /**
     * 奇数
     */
    public static class OddPrint implements Runnable {

        @Override
        public void run() {

            for (int i = 1; i <= max; i++) {
                try {
                    synchronized (OddAndEvenPrint.class) {
                        if (i % 2 == 1) {
                            System.out.println("奇：" + i);
                            OddAndEvenPrint.class.notify();
                        } else {
                            OddAndEvenPrint.class.wait();
                        }
                    }
                } catch (InterruptedException e) {
                }
            }

        }
    }

    /**
     * 偶数线程
     */
    public static class EvenPrint implements Runnable {

        @Override
        public void run() {

            for (int i = 1; i <= max; i++) {
                try {
                    synchronized (OddAndEvenPrint.class) {
                        if (i % 2 == 0) {
                            System.out.println("偶：" + i);
                            OddAndEvenPrint.class.notify();
                        } else {
                            OddAndEvenPrint.class.wait();
                        }
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }


    public static void main(String[] args) {
        EvenPrint evenPrint = new EvenPrint();
        OddPrint oddPrint = new OddPrint();
        new Thread(oddPrint).start();
        new Thread(evenPrint).start();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

