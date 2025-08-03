package leetcode.printInOrder1114;

public class Foo2 {

    private boolean secondDone = false;
    private boolean firstDone = false;

    public Foo2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (Foo2.class) {
            printFirst.run();
            Foo2.class.notifyAll();
            firstDone=true;
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (Foo2.class) {
            while (!firstDone) {
                Foo2.class.wait();
            }
            printSecond.run();
            secondDone = true;
            Foo2.class.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (Foo2.class) {
            while (!secondDone) {
                Foo2.class.wait();
            }
            printThird.run();
        }
    }
}
