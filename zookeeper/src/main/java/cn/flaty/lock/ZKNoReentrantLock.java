package cn.flaty.lock;

import cn.flaty.ZKProperties;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;

import java.io.IOException;
import java.util.List;

/**
 * @author flaty
 * @date 2020-5-16
 */
public class ZKNoReentrantLock extends ZKProperties {

    private String path;

    private CuratorFramework client;

    public ZKNoReentrantLock(String path) {
        this.client = super.getAndStartClient().newWatcherRemoveCuratorFramework();
        this.path = path+"";
    }

    public void lock() {
        try {
            String createdPath =  client.create().creatingParentContainersIfNeeded().withProtection().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(path);
            List<String>  children = client.getChildren().forPath(this.path);
            children.sort((o1, o2) -> o1.compareTo(o2));
            System.out.println(createdPath);
            System.out.println(children.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void unlock() {

    }


    public static void main(String[] args) throws IOException {
        ZKNoReentrantLock lock = new ZKNoReentrantLock("/flaty/myLock");
        lock.lock();
        System.in.read();
    }

}

