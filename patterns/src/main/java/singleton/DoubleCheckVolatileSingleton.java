package singleton;

/**
 * @author flaty-hp
 * @date 2020/3/10
 */
public class DoubleCheckVolatileSingleton {


    /**
     * 为了防止重排序
     */
    private static volatile DoubleCheckVolatileSingleton doubleCheck = null;

    private DoubleCheckVolatileSingleton() {

    }

    public static DoubleCheckVolatileSingleton getInstance() {
        if (doubleCheck == null) {
            synchronized (DoubleCheckVolatileSingleton.class) {
                if (doubleCheck == null) { // 这里会发生重排序。这里的if和下面的new可能会乱序执行
                    doubleCheck = new DoubleCheckVolatileSingleton();//分成三部。这里会发生重排序? 先分配内存，再初始化
                }
            }
        }
        return doubleCheck;
    }
}

