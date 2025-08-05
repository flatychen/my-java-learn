package leetcode.OddEvenOrder;

public class OddEvenPrinter {
    private static final int MAX = 3;
    private static int num = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> printOdd()).start();
        new Thread(() -> printEven()).start();
    }

    private static void printOdd() {
        synchronized (lock) {
//            System.out.println("printOdd");
            while (num <= MAX) {
                if (num % 2 == 1) {
                    System.out.println("odd: " + num++);
//                    System.out.println("odd notify");
                    lock.notify();
                } else {
//                    System.out.println("odd wait");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void printEven() {
        synchronized (lock) {
//            System.out.println("printEven");
            while (num <= MAX) {
                if (num % 2 == 0) {
                    System.out.println("even: " + num++);
//                    System.out.println("even notify");
                    lock.notify();
                } else {
//                    System.out.println("even wait");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}