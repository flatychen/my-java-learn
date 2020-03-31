package singleton;

/**
 * @author flaty-hp
 * @date 2020/3/10
 */
public class DoubleCheckSingleton {


    private static DoubleCheckSingleton doubleCheck = null;

    private DoubleCheckSingleton() {

    }

    public static DoubleCheckSingleton getInstance() {
        if (doubleCheck == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (doubleCheck == null) {
                    doubleCheck = new DoubleCheckSingleton();//分成三部。这里会发生重排序? 先分配内存，再初始化 //导致第二个线程取到空对象
                }
            }
        }
        return doubleCheck;
    }
}

