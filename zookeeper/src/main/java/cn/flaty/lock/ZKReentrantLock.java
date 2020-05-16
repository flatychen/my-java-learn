package cn.flaty.lock;

import cn.flaty.ZKProperties;

/**
 * @author flaty
 * @date 2020-5-16
 */
public class ZKReentrantLock extends ZKProperties {

    private String path;

    public ZKReentrantLock(String path) {
        this.path = path;
    }

    public void lock() {

    }



    public void unlock() {

    }


}

