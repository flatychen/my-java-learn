package cn.flaty;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author flaty
 * @date 2020-5-16
 */
public abstract class ZKProperties {


    public CuratorFramework getClient() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        String host = "zk.aomygod.api:2181";
        return CuratorFrameworkFactory.newClient(host,retryPolicy);

    }

}

