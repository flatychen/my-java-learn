package redission;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @author flaty-hp
 * @date 2020/4/6
 */
public class RedisConfig {

    private String redis = "redis://127.0.0.1:6379";




    public RedissonClient getClient() {
        Config config = new Config();
        config.useSingleServer().setAddress(redis).
                setConnectTimeout(1000 * 20).setConnectionMinimumIdleSize(1).setConnectionPoolSize(4);
        config.setNettyThreads(2);
        config.setThreads(2);
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }


}

