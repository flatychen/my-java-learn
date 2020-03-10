package singleton;

/**
 * @author flaty-hp
 * @date 2020/3/10
 */
public class DoubleCheckSingleton {


    /**
     * 为了防止重排序
     */
    private static volatile DoubleCheckSingleton doubleCheck = null;

    private DoubleCheckSingleton() {

    }

    public static DoubleCheckSingleton getInstance() {
        if (doubleCheck == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (doubleCheck == null) {
                    doubleCheck = new DoubleCheckSingleton();//分成三部。这里会发生重排序? 先分配内存，再初始化
                }
            }
        }
        return doubleCheck;
    }
}

