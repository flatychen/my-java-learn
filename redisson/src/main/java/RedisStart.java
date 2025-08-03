import redis.embedded.RedisServer;

/**
 * @author flaty
 * @date 2020-9-20
 */
public class RedisStart {

    public static void main(String[] args) {
        try {
            RedisServer redisServer = new RedisServer(6379);
            redisServer.start();
            System.out.println("redis start success!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

